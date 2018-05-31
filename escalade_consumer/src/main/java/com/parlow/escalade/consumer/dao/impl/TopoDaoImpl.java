package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.TopoDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.TopoMapper;
import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    @Inject
    protected DaoFactory daoFactory;

    @Override
    public Topo findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_topo,t_utilisateur WHERE topo_id = ? AND topo_utilisateur_fk_id=utilisateur_id";
        Topo topo = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new TopoMapper());
        return topo;
    }

    @Override
    public List<Topo> findAll() {
        String vSQL_findAll = "SELECT * FROM t_topo,t_utilisateur WHERE topo_utilisateur_fk_id = utilisateur_id ORDER BY topo_lastupdate DESC";
        List<Topo> topos  = this.vJdbcTemplate.query(vSQL_findAll, new TopoMapper());
        return topos;
    }

    @Override
    public List<Topo> findAllPublic() {
        String vSQL_findAll = "SELECT * FROM t_topo,t_utilisateur WHERE topo_publication = true AND topo_utilisateur_fk_id = utilisateur_id ORDER BY topo_lastupdate DESC";
        List<Topo> topos  = this.vJdbcTemplate.query(vSQL_findAll, new TopoMapper());
        return topos;
    }

    @Override
    public int insert(Topo pTopo) throws FunctionalException, TechnicalException {
        String vSQL_insert = "INSERT into t_topo (topo_nom,topo_description, topo_region, topo_lastUpdate, topo_image, topo_dateCreation, topo_utilisateur_fk_id, topo_publication, topo_disponible) VALUES(?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"topo_id"});
                                           pst.setString(1, pTopo.getNom());
                                           pst.setString(2, pTopo.getDescription());
                                           pst.setString(3, pTopo.getRegion());
                                           pst.setTimestamp(4, pTopo.getDateCreation());
                                           pst.setString(5, pTopo.getImage());
                                           pst.setTimestamp(6, pTopo.getDateCreation());
                                           pst.setInt(7, pTopo.getUtilisateur().getId());
                                           pst.setBoolean(8, false);
                                           pst.setBoolean(9, false);
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException, TechnicalException {
        String vSQL_delete = "DELETE FROM t_topo WHERE topo_id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Topo pTopo) throws FunctionalException {
        String vSQL_update = "UPDATE t_topo SET topo_nom = ?, topo_region = ?, topo_description = ?, topo_lastUpdate = ?, topo_image = ?," +
                "  topo_publication = ?, topo_disponible = ?, topo_nbsites=?, topo_nbsecteurs=?, topo_nbvoies=? WHERE topo_id = ?";
        this.vJdbcTemplate.update(vSQL_update, pTopo.getNom(), pTopo.getRegion(),pTopo.getDescription(),pTopo.getLastUpdate(),
                pTopo.getImage(),pTopo.isPublication(), pTopo.isDisponible(), pTopo.getNbSites(), pTopo.getNbSecteurs(), pTopo.getNbVoies(), pTopo.getId());
    }

    @Override
    public List<Topo> searchResult(String keyWord) {
        String vSQL_findAll = "SELECT * FROM t_topo, t_utilisateur where concat(topo_nom,topo_description,topo_datecreation,topo_region,utilisateur_nom,utilisateur_prenom)  ILIKE ? AND topo_utilisateur_fk_id = utilisateur_id ORDER BY topo_datecreation DESC";
        List<Topo> topos  = this.vJdbcTemplate.query(vSQL_findAll, new Object[] { keyWord }, new RowMapper<Topo>() {
            @Override
            public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
                TopoMapper topoMapper = new TopoMapper();
                return topoMapper.mapRow(rs, rowNum);
            }
        });

        return topos;
    }

    @Override
    public Topo findByName(String pNom) throws NotFoundException {
        String sql_findByName = "SELECT * FROM t_topo, t_utilisateur WHERE topo_nom = ? AND topo_utilisateur_fk_id = utilisateur_id";

        try {
            Topo topo = this.vJdbcTemplate.queryForObject(
                    sql_findByName, new Object[]{pNom}, new TopoMapper());
            return topo;
        }catch(Exception e){
            throw new NotFoundException("Aucun topo correspondant à ce nom fourni.");
        }

    }

    @Override
    public List<Topo> findListByUserId(int id) {
        String vSQL_findAll = "SELECT * FROM t_topo,t_utilisateur WHERE topo_publication = true AND topo_utilisateur_fk_id=? AND topo_utilisateur_fk_id = utilisateur_id ORDER BY topo_lastupdate DESC";
        List<Topo> topos  = this.vJdbcTemplate.query(vSQL_findAll, new TopoMapper(),id);

        return topos;
    }
}
