package com.maxs.dao;

import com.maxs.model.ColourModel;

import java.util.List;
import java.util.Map;

public interface IColourDao {
    List<Map> getColour(String goodsId);

    int delColour(String colourId);

    int addColour(ColourModel colourModel);
}
