package com.maxs.controller;


import com.alibaba.fastjson.JSON;
import com.maxs.common.RequestIsJson;
import com.maxs.common.ReturnMap;
import com.maxs.model.ColourModel;
import com.maxs.model.EditionModel;
import com.maxs.service.EditionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class EditionController {

    ReturnMap returnMap = new ReturnMap();
    EditionModel editionModel;
    private Class claszz = EditionModel.class;
    private RequestIsJson<EditionModel> requestIsJson = new RequestIsJson<>();
    /**
     * 版本查询-----根据商品id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getEdition",method = RequestMethod.POST)
    public String getEdition(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        EditionService editionService = new EditionService();
        editionModel = requestIsJson.getJsonToModel(request, claszz);
        List<Map> list = editionService.getEdition(editionModel.getGoodId());
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
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        editionModel = requestIsJson.getJsonToModel(request, claszz);
        EditionService editionService = new EditionService();
        int i = editionService.updateEditionName(editionModel);
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
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        editionModel = requestIsJson.getJsonToModel(request, claszz);
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
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        editionModel = requestIsJson.getJsonToModel(request, claszz);
        EditionService editionService = new EditionService();
        int i = editionService.addEdition(editionModel);
        return returnMap.getaddReMap(i);
    }
}
