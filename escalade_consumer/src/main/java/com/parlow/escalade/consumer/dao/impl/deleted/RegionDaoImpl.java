package com.parlow.escalade.consumer.dao.impl.deleted;

import com.parlow.escalade.consumer.dao.contract.deleted.RegionDao;
import com.parlow.escalade.consumer.dao.impl.AbstractDaoImpl;
import com.parlow.escalade.model.bean.deleted.Region;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Named
public class RegionDaoImpl extends AbstractDaoImpl implements RegionDao {
    
    @Override
    public List<Region> findAll() {
        String vSQL_findAll = "SELECT * FROM t_region ORDER BY region ASC ";
        List<Region> regions  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Region.class));

        return regions;
    }

    @Override
    public Region findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_region WHERE id = ?";
        Region region = (Region) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Region.class));
        return region;
    }

    @Override
    public int insert(Region pRegion) throws FunctionalException {
        String vSQL_insert = "INSERT into t_region (id,region) VALUES(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setInt(1, pRegion.getId());
                                           pst.setString(1, pRegion.getRegion());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = 1;
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_region WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Region pRegion) throws FunctionalException {
        String vSQL_update = "UPDATE t_region SET region = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pRegion.getRegion(), pRegion.getId());
    }
}
