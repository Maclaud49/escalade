package com.parlow.escalade.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.parlow.escalade.business.manager.ManagerFactory;
import com.parlow.escalade.business.manager.ManagerFactoryImpl;
import com.parlow.escalade.business.manager.SecteurManagerImpl;
import com.parlow.escalade.business.manager.SiteManagerImpl;
import com.parlow.escalade.webapp.rest.resource.AbstractResource;


public class DependencyInjectionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent pServletContextEvent) {
        // Création de l'instance de ManagerFactory
        ManagerFactory vManagerFactory = new ManagerFactoryImpl();
        // On ajoute l'injection des Managers dans la ManagerFactory
        vManagerFactory.setSiteManager(new SiteManagerImpl());
        vManagerFactory.setSecteurManager(new SecteurManagerImpl());

        // Injection de l'instance de ManagerFactory dans la classe AbstractResource
        AbstractResource.setManagerFactory(vManagerFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent pServletContextEvent) {
        // NOP
    }
}