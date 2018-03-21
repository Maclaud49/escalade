package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.TypeRocherDao;
import com.parlow.escalade.model.bean.TypeRocher;
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
public class TypeRocherDaoImpl extends AbstractDaoImpl implements TypeRocherDao{

    @Override
    public TypeRocher findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_typeRocher WHERE id = ?";
        TypeRocher typeRocher = (TypeRocher) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(TypeRocher.class));
        return typeRocher;
    }

    @Override
    public List<TypeRocher> findAll() {
        String vSQL_findAll = "SELECT * FROM t_typeRocher";
        List<TypeRocher> typeRochers  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(TypeRocher.class));
        return typeRochers;
    }

    @Override
    public int insert(TypeRocher pTypeRocher) throws FunctionalException {
        String vSQL_insert = "INSERT into t_typeRocher (typeRocher) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pTypeRocher.getTypeRocher());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_typeRocher WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(TypeRocher pTypeRocher) throws FunctionalException {
        String vSQL_update = "UPDATE t_typeRocher SET typeRocher = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pTypeRocher.getTypeRocher(), pTypeRocher.getId());
    }
}
