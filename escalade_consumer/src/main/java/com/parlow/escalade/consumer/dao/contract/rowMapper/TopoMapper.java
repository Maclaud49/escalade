package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.impl.UtilisateurDaoImpl;
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
public class TopoMapper implements RowMapper<Topo> {
    private static final Logger logger = LogManager.getLogger(TopoMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {

        Topo topo = new Topo();
        topo.setId(rs.getInt("topo_id"));
        topo.setNom(rs.getString("topo_nom"));
        topo.setDescription(rs.getString("topo_description"));
        topo.setDateCreation(rs.getTimestamp("topo_dateCreation"));
        topo.setLastUpdate(rs.getTimestamp("topo_lastUpdate"));
        topo.setDisponible(rs.getBoolean("topo_disponible"));
        topo.setImage(rs.getString("topo_image"));
        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        topo.setUtilisateur(utilisateur);
        topo.setRegion(rs.getString("topo_region"));
        topo.setNbSites(rs.getInt("topo_nbsites"));
        topo.setNbSecteurs(rs.getInt("topo_nbsecteurs"));
        topo.setNbVoies(rs.getInt("topo_nbvoies"));


        return topo;
    }

}


