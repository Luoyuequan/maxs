package com.maxs.service;

import com.maxs.dao.IEditionDao;
import com.maxs.dao.impl.EditionDaoImpl;
import com.maxs.model.EditionModel;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EditionService {
    public List<Map> getEdition(String goodsId) {

        IEditionDao iEditionDao = new EditionDaoImpl();
        return iEditionDao.getEditon(goodsId);
    }

    public int updateEditionName(EditionModel editionModel,String newEditionName) {

        IEditionDao iEditionDao = new EditionDaoImpl();
        return iEditionDao.updateEdition(editionModel,newEditionName);
    }

    public int delEdition(EditionModel editionModel) {

        IEditionDao iEditionDao = new EditionDaoImpl();
        return iEditionDao.delEdition(editionModel);
    }

    public int addEdition(EditionModel editionModel) {

        IEditionDao iEditionDao = new EditionDaoImpl();
        return iEditionDao.addEdition(editionModel);
    }
}
