package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.ImageManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Image;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ImageManagerImpl extends AbstractManager implements ImageManager{
    @Inject
    private DaoFactory daoFactory;

    @Override
    public Image findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Image non trouvé : ID=" + pId);
        }
        Image vImage = daoFactory.getImageDao().findById(pId);
        return vImage;
    }

    @Override
    public List<Image> findAll() {
        List<Image> vList = daoFactory.getImageDao().findAll();
        if (vList == null) {
            Image image = new Image();
            image.setId(1);
            image.setNom("Pas de données");
            vList.add(image);
        }
        return vList;
    }

    @Override
    public int insert(Image pImage) throws FunctionalException {
        if (pImage == null) {
            throw new FunctionalException("L'objet Image ne doit pas être null !");
        }
        return daoFactory.getImageDao().insert(pImage);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Image non trouvé : ID=" + pId);
        }
        daoFactory.getImageDao().delete(pId);
    }

    @Override
    public void update(Image pImage) throws FunctionalException {
        if (pImage == null) {
            throw new FunctionalException("L'objet Image ne doit pas être null !");
        }
        daoFactory.getImageDao().update(pImage);
    }
    
}
