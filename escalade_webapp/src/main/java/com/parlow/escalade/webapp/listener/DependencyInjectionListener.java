package com.parlow.escalade.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.business.manager.impl.ManagerFactoryImpl;
import com.parlow.escalade.business.manager.impl.SecteurManagerImpl;
import com.parlow.escalade.business.manager.impl.SiteManagerImpl;
import com.parlow.escalade.webapp.rest.resource.AbstractResource;


public class DependencyInjectionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent pServletContextEvent) {
        // Création de l'instance de ManagerFactory
        ManagerFactory vManagerFactory = new ManagerFactoryImpl(new SiteManagerImpl(),new SecteurManagerImpl());

        // Injection de l'instance de ManagerFactory dans la classe AbstractResource
        AbstractResource.setManagerFactory(vManagerFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent pServletContextEvent) {
        // NOP
    }
}