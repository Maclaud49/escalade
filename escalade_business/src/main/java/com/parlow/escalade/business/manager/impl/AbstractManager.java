package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;

import javax.inject.Inject;
import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public abstract class AbstractManager {


    @Inject
    protected DaoFactory daoFactory;

    /**
     * Renvoie un {@link Validator} de contraintes
     *
     * @return Validator
     */
    protected Validator getConstraintValidator() {
        Configuration<?> vConfiguration = Validation.byDefaultProvider().configure();
        ValidatorFactory vFactory = vConfiguration.buildValidatorFactory();
        Validator vValidator = vFactory.getValidator();
        return vValidator;
    }


}
