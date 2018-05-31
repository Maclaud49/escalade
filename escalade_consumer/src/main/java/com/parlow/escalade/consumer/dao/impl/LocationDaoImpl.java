package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.LocationDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.LocationMapper;
import com.parlow.escalade.model.bean.Location;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
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
        String vSQL_findById = "SELECT * FROM t_location_topo,t_topo,t_utilisateur  WHERE loc_topo_fk_id = topo_id  AND loc_id = ? AND topo_utilisateur_fk_id=utilisateur_id ORDER BY loc_datedebut DESC";
        Location location = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId}, new LocationMapper());
        return location;
    }

    @Override
    public List<Location> findAll() {
        String vSQL_findAll = "SELECT * FROM t_location_topo, t_topo,t_utilisateur WHERE loc_topo_fk_id = topo_id AND topo_utilisateur_fk_id=utilisateur_id ORDER BY loc_datedebut DESC";
        List<Location> locations = this.vJdbcTemplate.query(vSQL_findAll, new LocationMapper());
        return locations;
    }

    @Override
    public int insert(Location pLocation) throws FunctionalException, TechnicalException {
        String vSQL_insert = "INSERT INTO t_location_topo (loc_dateDebut, loc_topoProprioUser_fk_id, loc_topoLoueurUser_fk_id, loc_topo_fk_id, loc_status) VALUES(?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update(new PreparedStatementCreator() {
                                      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                          PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"loc_id"});
                                          pst.setTimestamp(1, pLocation.getDateDebut());
                                          pst.setInt(2, pLocation.getTopoProprio());
                                          pst.setInt(3, pLocation.getTopoLoueur());
                                          pst.setInt(4, pLocation.getTopo().getId());
                                          pst.setString(5, pLocation.getStatus());
                                          return pst;
                                      }
                                  },
                keyHolder);
        int key = (Integer) keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_location_topo WHERE loc_id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Location pLocation) throws FunctionalException {
        String vSQL_update = "UPDATE t_location_topo SET loc_dateDebut = ?, loc_dateFin = ?, loc_topoProprioUser_fk_id = ?," +
                " loc_topoLoueurUser_fk_id = ?, loc_topo_fk_id = ?, loc_status = ? WHERE loc_id = ?";
        this.vJdbcTemplate.update(vSQL_update, pLocation.getDateDebut(), pLocation.getDateFin(),pLocation.getTopoProprio(),
                pLocation.getTopoLoueur(),pLocation.getTopo().getId(),pLocation.getStatus(), pLocation.getId());
    }
}
