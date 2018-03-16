package com.parlow.escalade.webapp.converter.locator;


import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import javax.inject.Inject;
import java.util.Map;

/**
 * Locator d'{@link Utilisateur} via son identifiant.
 */
public class UtilisateurLocator extends StrutsTypeConverter {
    @Inject
    private ManagerFactory managerFactory;


    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            :  managerFactory.getUtilisateurManager().getUtilisateur(new Integer(vValue));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant utilisateur invalide", pEx);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Utilisateur introuvable", pEx);
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }

        return vRetour;
    }


    @Override
    public String convertToString(Map pContext, Object pObject) {
        String vString;
        if (pObject instanceof Utilisateur) {
            Utilisateur vUtilisateur = (Utilisateur) pObject;
            vString
                    = vUtilisateur.getId() != null
                    ? vUtilisateur.getId().toString()
                    : "";
        } else {
            vString = "";
        }
        return vString;
    }
}
