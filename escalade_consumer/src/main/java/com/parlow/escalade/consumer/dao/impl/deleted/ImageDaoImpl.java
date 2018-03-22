package com.parlow.escalade.consumer.dao.impl.deleted;

import com.parlow.escalade.consumer.dao.contract.deleted.ImageDao;
import com.parlow.escalade.consumer.dao.impl.AbstractDaoImpl;
import com.parlow.escalade.model.bean.deleted.Image;
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
public class ImageDaoImpl extends AbstractDaoImpl implements ImageDao {

    @Override
    public Image findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_image WHERE id = ?";
        Image image = (Image) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Image.class));
        return image;
    }

    @Override
    public List<Image> findAll() {
        String vSQL_findAll = "SELECT * FROM t_image";
        List<Image> images  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Image.class));
        return images;
    }

    @Override
    public int insert(Image pImage) throws FunctionalException {
        String vSQL_insert = "INSERT into t_image (chemin) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           try (PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"id"})) {
                                               pst.setString(1, pImage.getChemin());
                                               return pst;
                                           }
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_image WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Image pImage) throws FunctionalException {
        String vSQL_update = "UPDATE t_image SET chemin = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pImage.getChemin(), pImage.getId());
    }

}
