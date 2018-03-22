package com.parlow.escalade.business.manager.impl.deleted;

import com.parlow.escalade.business.manager.contract.deleted.CotationManager;
import com.parlow.escalade.business.manager.impl.AbstractManager;
import com.parlow.escalade.model.bean.deleted.Cotation;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.List;

@Named
public class CotationManagerImpl extends AbstractManager implements CotationManager{


    @Override
    public Cotation findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Cotation non trouvé : ID=" + pId);
        }
        Cotation vCotation = daoFactory.getCotationDao().findById(pId);
        return vCotation;
    }

    @Override
    public List<Cotation> findAll() {
        List<Cotation> vList = daoFactory.getCotationDao().findAll();
        if (vList == null) {
            Cotation cotation = new Cotation();
            cotation.setId(1);
            cotation.setCotation("Pas de données");
            vList.add(cotation);
        }
        return vList;
    }

    @Override
    public int insert(Cotation pCotation) throws FunctionalException {
        if (pCotation == null) {
            throw new FunctionalException("L'objet Cotation ne doit pas être null !");
        }
        return daoFactory.getCotationDao().insert(pCotation);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Cotation non trouvé : ID=" + pId);
        }
        daoFactory.getCotationDao().delete(pId);
    }

    @Override
    public void update(Cotation pCotation) throws FunctionalException {
        if (pCotation == null) {
            throw new FunctionalException("L'objet Cotation ne doit pas être null !");
        }
        daoFactory.getCotationDao().update(pCotation);
    }
    
}
