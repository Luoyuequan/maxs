package com.maxs.dao;

import com.maxs.model.EditionModel;

import java.util.List;
import java.util.Map;

public interface IEditionDao {
    List<Map> getEditon(String goodsId);

    int updateEdition(EditionModel editionModel);

    int delEdition(EditionModel editionModel);

    int addEdition(EditionModel editionModel);
}
