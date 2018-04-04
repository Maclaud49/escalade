package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {

    protected DataSource dataSource;
    protected JdbcTemplate vJdbcTemplate ;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.vJdbcTemplate = new JdbcTemplate(dataSource);
    }


}