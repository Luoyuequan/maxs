package com.maxs.service;

import com.maxs.dao.IColourDao;
import com.maxs.dao.impl.ColorDaoImpl;
import com.maxs.model.ColourModel;

import java.util.List;
import java.util.Map;

public class ColourService {
    IColourDao iColourDao = new ColorDaoImpl();

    public List<Map> getColour(String goodsId) {

        return iColourDao.getColour(goodsId);
    }

    public int delColour(String colourId) {

        return iColourDao.delColour(colourId);
    }

    public int addColour(ColourModel colourModel) {

        return iColourDao.addColour(colourModel);
    }
}
