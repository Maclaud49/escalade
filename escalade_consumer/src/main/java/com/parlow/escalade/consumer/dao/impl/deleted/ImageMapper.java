package com.parlow.escalade.consumer.dao.impl.deleted;

import com.parlow.escalade.model.bean.deleted.Image;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper<Image> {
    public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
        Image image = new Image();
        image.setId(rs.getInt("id"));
        image.setChemin(rs.getString("chemin"));

        return image;
    }
}

