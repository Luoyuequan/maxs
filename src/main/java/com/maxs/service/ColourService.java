package com.maxs.service;

import com.maxs.dao.IColourDao;
import com.maxs.dao.impl.ColorDaoImpl;

import java.util.List;
import java.util.Map;

public class ColourService {
    public List<Map> getColour(String goodsId) {

        IColourDao iColourDao = new ColorDaoImpl();
        List<Map> list = iColourDao.getColour(goodsId);
        return list;
    }
}
