package com.parlow.escalade.consumer.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSourceEscalade")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }
}