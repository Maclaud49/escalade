package com.parlow.escalade.consumer.dao.impl.deleted;

import com.parlow.escalade.consumer.dao.contract.deleted.CotationDao;
import com.parlow.escalade.consumer.dao.impl.AbstractDaoImpl;
import com.parlow.escalade.model.bean.deleted.Cotation;
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
public class CotationDaoImpl extends AbstractDaoImpl implements CotationDao {

    @Override
    public Cotation findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_cotation WHERE id = ?";
        Cotation cotation = (Cotation) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Cotation.class));
        return cotation;
    }

    @Override
    public List<Cotation> findAll() {
        String vSQL_findAll = "SELECT * FROM t_cotation";
        List<Cotation> cotations = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Cotation.class));
        return cotations;
    }

    @Override
    public int insert(Cotation pCotation) throws FunctionalException {
        String vSQL_insert = "INSERT INTO t_cotation (cotation,niveau) VALUES(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update(new PreparedStatementCreator() {
                                      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                          PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"id"});
                                          pst.setString(1, pCotation.getCotation());
                                          pst.setInt(1, pCotation.getNiveau());
                                          return pst;
                                      }
                                  },
                keyHolder);
        int key = (Integer) keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_cotation WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Cotation pCotation) throws FunctionalException {
        String vSQL_update = "UPDATE t_cotation SET cotation = ?, niveau = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pCotation.getCotation(), pCotation.getNiveau(), pCotation.getId());
    }
}
