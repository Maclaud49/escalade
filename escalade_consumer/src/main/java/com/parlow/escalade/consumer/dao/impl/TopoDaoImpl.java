package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.TopoDao;
import com.parlow.escalade.model.bean.Topo;
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
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    @Override
    public Topo findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_topo WHERE id = ?";
        Topo topo = (Topo) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Topo.class));
        return topo;
    }

    @Override
    public List<Topo> findAll() {
        String vSQL_findAll = "SELECT * FROM t_topo";
        List<Topo> topos  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Topo.class));
        return topos;
    }

    @Override
    public int insert(Topo pTopo) throws FunctionalException {
        String vSQL_insert = "INSERT into t_topo (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pTopo.getNom());
                                           pst.setString(2,pTopo.getDescription());
                                           pst.setInt(3,pTopo.getRegion().getId());
                                           pst.setTimestamp(4,pTopo.getDateCreation());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_topo WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Topo pTopo) throws FunctionalException {
        String vSQL_update = "UPDATE t_topo SET age = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, age, id);
    }
}
