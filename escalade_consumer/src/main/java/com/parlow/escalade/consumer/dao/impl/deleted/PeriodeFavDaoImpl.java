package com.parlow.escalade.consumer.dao.impl.deleted;

import com.parlow.escalade.consumer.dao.contract.deleted.PeriodeFavDao;
import com.parlow.escalade.consumer.dao.impl.AbstractDaoImpl;
import com.parlow.escalade.model.bean.deleted.PeriodeFav;
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
public class PeriodeFavDaoImpl extends AbstractDaoImpl implements PeriodeFavDao{

        @Override
        public PeriodeFav findById(int pId) throws NotFoundException {
            String vSQL_findById = "SELECT * FROM t_periodeFav WHERE id = ?";
            PeriodeFav periodeFav = (PeriodeFav) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                    new BeanPropertyRowMapper(PeriodeFav.class));
            return periodeFav;
        }

        @Override
        public List<PeriodeFav> findAll() {
            String vSQL_findAll = "SELECT * FROM t_periodeFav";
            List<PeriodeFav> periodeFavs  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(PeriodeFav.class));
            return periodeFavs;
        }

        @Override
        public int insert(PeriodeFav pPeriodeFav) throws FunctionalException {
            String vSQL_insert = "INSERT into t_periodeFav (periode) VALUES(?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                           public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                               PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                               pst.setString(1, pPeriodeFav.getPeriode());
                                               return pst;
                                           }
                                       },
                    keyHolder);
            int key = (Integer)keyHolder.getKey();
            return key;
        }

        @Override
        public void delete(int pId) throws NotFoundException {
            String vSQL_delete = "DELETE FROM t_periodeFav WHERE id=?";
            this.vJdbcTemplate.update(vSQL_delete, pId);
        }

        @Override
        public void update(PeriodeFav pPeriodeFav) throws FunctionalException {
            String vSQL_update = "UPDATE t_periodeFav SET periode = ? WHERE id = ?";
            this.vJdbcTemplate.update(vSQL_update, pPeriodeFav.getPeriode(), pPeriodeFav.getId());
        }
}
