package com.parlow.escalade.business.manager.impl.deleted;

import com.parlow.escalade.business.manager.contract.deleted.AdresseManager;
import com.parlow.escalade.business.manager.impl.AbstractManager;
import com.parlow.escalade.model.bean.Adresse;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.List;

@Named
public class AdresseManagerImpl extends AbstractManager implements AdresseManager {

    @Override
    public Adresse findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Adresse non trouvé : ID=" + pId);
        }
        Adresse vAdresse = daoFactory.getAdresseDao().findById(pId);
        return vAdresse;
    }

    @Override
    public List<Adresse> findAll() {
        List<Adresse> vList = daoFactory.getAdresseDao().findAll();
        if (vList == null) {
            Adresse adresse = new Adresse();
            adresse.setId(1);
            adresse.setAdresse1("Pas de données");
            vList.add(adresse);
        }
        return vList;
    }

    @Override
    public int insert(Adresse pAdresse) throws FunctionalException {
        if (pAdresse == null) {
            throw new FunctionalException("L'objet Adresse ne doit pas être null !");
        }
        return daoFactory.getAdresseDao().insert(pAdresse);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Adresse non trouvé : ID=" + pId);
        }
        daoFactory.getAdresseDao().delete(pId);
    }

    @Override
    public void update(Adresse pAdresse) throws FunctionalException {
        if (pAdresse == null) {
            throw new FunctionalException("L'objet Adresse ne doit pas être null !");
        }
        daoFactory.getAdresseDao().update(pAdresse);
    }
}
