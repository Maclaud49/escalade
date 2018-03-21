package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.LocationDao;
import com.parlow.escalade.model.bean.Location;
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
public class LocationDaoImpl extends AbstractDaoImpl implements LocationDao {

    @Override
    public Location findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_location WHERE id = ?";
        Location location = (Location) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Location.class));
        return location;
    }

    @Override
    public List<Location> findAll() {
        String vSQL_findAll = "SELECT * FROM t_location";
        List<Location> locations = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Location.class));
        return locations;
    }

    @Override
    public int insert(Location pLocation) throws FunctionalException {
        String vSQL_insert = "INSERT INTO t_location (dateDebut, topoProprioUtilisateur_fk_id, topoLoueurUtilisateur_fk_id, topo_fk_id) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update(new PreparedStatementCreator() {
                                      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                          PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"id"});
                                          pst.setTimestamp(1, pLocation.getDateDebut());
                                          pst.setInt(2, pLocation.getTopoProprio().getId());
                                          pst.setInt(3, pLocation.getTopoLoueur().getId());
                                          pst.setInt(4, pLocation.getTopo().getId());
                                          return pst;
                                      }
                                  },
                keyHolder);
        int key = (Integer) keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_location WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Location pLocation) throws FunctionalException {
        String vSQL_update = "UPDATE t_location SET dateDebut = ?, dateFin = ?, topoProprioUtilisateur_fk_id = ?," +
                " topoLoueurUtilisateur_fk_id = ?, topo_fk_id = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pLocation.getDateDebut(), pLocation.getDateFin(),pLocation.getTopoProprio().getId(),
                pLocation.getTopoLoueur().getId(),pLocation.getTopo().getId(),pLocation.getId());
    }
}
