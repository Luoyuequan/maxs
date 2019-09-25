package com.maxs.service;

import com.maxs.dao.IColourDao;
import com.maxs.dao.impl.ColorImpl;
import com.maxs.model.ColourModel;

import java.util.List;
import java.util.Map;

public class ColourService {
    public List<Map> getColour() {

        IColourDao iColourDao = new ColorImpl();
        List<Map> list = iColourDao.getColour();
        return list;
    }
}
