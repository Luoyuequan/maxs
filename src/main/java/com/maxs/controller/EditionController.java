package com.maxs.controller;


import com.alibaba.fastjson.JSON;
import com.maxs.common.ReturnMap;
import com.maxs.model.EditionModel;
import com.maxs.service.EditionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EditionController {

    ReturnMap returnMap = new ReturnMap();
    /**
     * 版本查询-----根据商品id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getEdition",method = RequestMethod.POST)
    public String getEdition(HttpServletRequest request, HttpServletResponse response){
        String goodsId = request.getParameter("goodId");
        EditionService editionService = new EditionService();
        List<Map> list = editionService.getEdition(goodsId);
        return returnMap.getGetReMap(list);
    }

    /**
     * 版本修改
     * @param request good_id,old_edition_name(旧版本号),new_edition_name（新版本号）
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateEdition",method = RequestMethod.POST)
    public String updateEdition(HttpServletRequest request,HttpServletResponse response){
        String editionId = request.getParameter("editionId");

        String newEditionName = request.getParameter("newEditionName");
        EditionModel editionModel = new EditionModel();
        editionModel.setEditionId(editionId);
        EditionService editionService = new EditionService();
        int i = editionService.updateEditionName(editionModel,newEditionName);
        return returnMap.getUpdateReMap(i);
    }

    /**
     * 版本删除
     * @param request good_id，edition_name
     * @param response json
     * @return
     */
    @RequestMapping(value = "/delEdition",method = RequestMethod.POST)
    public String delEdition(HttpServletRequest request,HttpServletResponse response){
        String editionId = request.getParameter("editionId");
        EditionModel editionModel = new EditionModel();

        editionModel.setEditionId(editionId);
        EditionService editionService = new EditionService();
        int i = editionService.delEdition(editionModel);
        return returnMap.getdelReMap(i);
    }

    /**
     * 添加版本
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/addEdition",method = RequestMethod.POST)
    public String addEdition(HttpServletRequest request,HttpServletResponse response){
        String goodsId = request.getParameter("goodId");
        String editionName = request.getParameter("editionName");
        EditionModel editionModel = new EditionModel();
        editionModel.setGoodId(goodsId);
        editionModel.setEditionName(editionName);
        EditionService editionService = new EditionService();
        int i = editionService.addEdition(editionModel);
        return returnMap.getaddReMap(i);
    }
}
