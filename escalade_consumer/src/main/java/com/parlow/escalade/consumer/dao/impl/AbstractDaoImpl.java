package com.parlow.escalade.consumer.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {



    @Inject
    protected DataSource dataSource;

    protected JdbcTemplate vJdbcTemplate = new JdbcTemplate(dataSource);

    public DataSource getDataSource() {
        return dataSource;
    }
}