package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.AdresseDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.AdresseMapper;
import com.parlow.escalade.model.bean.Adresse;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class AdresseDaoImpl extends AbstractDaoImpl implements AdresseDao {

    @Override
    public Adresse findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_adresse WHERE id = ?";
        Adresse adresse = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new AdresseMapper());
        return adresse;
    }

    @Override
    public List<Adresse> findAll() {
        String vSQL_findAll = "SELECT * FROM t_adresse";
        List<Adresse> adresses  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Adresse.class));
        return adresses;
    }

    @Override
    public int insert(Adresse pAdresse) throws FunctionalException {
        String vSQL_insert = "INSERT into t_adresse (adresse1, adresse2) VALUES(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pAdresse.getAdresse1());
                                           pst.setString(2,pAdresse.getAdresse2());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_adresse WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Adresse pAdresse) throws FunctionalException {
        String vSQL_update = "UPDATE t_adresse SET adresse1 = ?,adresse2 = ?,codePostal = ?,ville = ?,pays = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pAdresse.getAdresse1(),pAdresse.getAdresse2(),pAdresse.getCodePostal(),
                pAdresse.getVille(),pAdresse.getPays(),pAdresse.getId());
    }

    public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("Adresse mapRow");
        Adresse adresse = new Adresse();
        adresse.setId(rs.getInt("id"));
        adresse.setAdresse1(rs.getString("adresse1"));
        adresse.setAdresse2(rs.getString("adresse2"));
        adresse.setCodePostal(rs.getString("codePostal"));
        adresse.setVille(rs.getString("ville"));
        adresse.setPays(rs.getString("pays"));
        return adresse;
    }
}
