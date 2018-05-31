package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Location;
import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class LocationMapper implements RowMapper<Location> {
    private static final Logger logger = LogManager.getLogger(LocationMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {

        Location location = new Location();
        location.setId(rs.getInt("loc_id"));
        location.setDateDebut(rs.getTimestamp("loc_datedebut"));
        location.setDateFin(rs.getTimestamp("loc_datefin"));

        location.setTopoProprio(rs.getInt("loc_topopropriouser_fk_id"));
        location.setTopoLoueur(rs.getInt("loc_topoloueuruser_fk_id"));

        TopoMapper topoMapper = new TopoMapper();
        Topo topo = topoMapper.mapRow(rs,rowNum);
        location.setTopo(topo);
        location.setStatus(rs.getString("loc_status"));

        return location;
    }

}


