package com.parlow.escalade.business.manager.impl.deleted;

import com.parlow.escalade.business.manager.contract.deleted.PeriodeFavManager;
import com.parlow.escalade.business.manager.impl.AbstractManager;
import com.parlow.escalade.model.bean.deleted.PeriodeFav;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.List;

@Named
public class PeriodeFavManagerImpl extends AbstractManager implements PeriodeFavManager{


    @Override
    public PeriodeFav findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("PeriodeFav non trouvé : ID=" + pId);
        }
        PeriodeFav vPeriodeFav = daoFactory.getPeriodeFavDao().findById(pId);
        return vPeriodeFav;
    }

    @Override
    public List<PeriodeFav> findAll() {
        List<PeriodeFav> vList = daoFactory.getPeriodeFavDao().findAll();
        if (vList == null) {
            PeriodeFav periodeFav = new PeriodeFav();
            periodeFav.setId(1);
            periodeFav.setPeriode("Pas de données");
            vList.add(periodeFav);
        }
        return vList;
    }

    @Override
    public int insert(PeriodeFav pPeriodeFav) throws FunctionalException {
        if (pPeriodeFav == null) {
            throw new FunctionalException("L'objet PeriodeFav ne doit pas être null !");
        }
        return daoFactory.getPeriodeFavDao().insert(pPeriodeFav);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("PeriodeFav non trouvé : ID=" + pId);
        }
        daoFactory.getPeriodeFavDao().delete(pId);
    }

    @Override
    public void update(PeriodeFav pPeriodeFav) throws FunctionalException {
        if (pPeriodeFav == null) {
            throw new FunctionalException("L'objet PeriodeFav ne doit pas être null !");
        }
        daoFactory.getPeriodeFavDao().update(pPeriodeFav);
    }
}
