package com.maxs.controller;


import com.alibaba.fastjson.JSON;
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

    /**
     * 版本查询-----根据商品id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getEdition")
    public String getEdition(HttpServletRequest request, HttpServletResponse response){
        String goodsId = request.getParameter("good_id");
        EditionService editionService = new EditionService();
        List<Map> list = editionService.getEdition(goodsId);
        String json = JSON.toJSONString(list);
        return json;
    }

    /**
     * 版本修改
     * @param request good_id,old_edition_name(旧版本号),new_edition_name（新版本号）
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateEdition")
    public String updateEdition(HttpServletRequest request,HttpServletResponse response){
        String goodsId = request.getParameter("good_id");
        String oldEditionName = request.getParameter("old_edition_name");
        String newEditionName = request.getParameter("new_edition_name");
        EditionModel editionModel = new EditionModel();
        editionModel.setGoodId(goodsId);
        editionModel.setEditionName(oldEditionName);
        EditionService editionService = new EditionService();
        int i = editionService.updateEditionName(editionModel,newEditionName);
        Map<String,String> map = new HashMap<>();
        if (i>0){
            map.put("retCode","1");
            map.put("retMsg","修改成功");
        }else {
            map.put("retCode","0");
            map.put("retMsg","修改失败");
        }
        String json = JSON.toJSONString(map);
        return json;
    }

    /**
     * 版本修改
     * @param request good_id，edition_name
     * @param response json
     * @return
     */
    @RequestMapping(value = "/delEdition")
    public String delEdition(HttpServletRequest request,HttpServletResponse response){
        String goodsId = request.getParameter("good_id");
        String editionName = request.getParameter("edition_name");
        EditionModel editionModel = new EditionModel();
        editionModel.setGoodId(goodsId);
        editionModel.setEditionName(editionName);
        EditionService editionService = new EditionService();
        int i = editionService.delEdition(editionModel);
        Map<String,String> map = new HashMap<>();
        if (i>0){
            map.put("retCode","1");
            map.put("retMsg","删除成功");
        }else {
            map.put("retCode","0");
            map.put("retMsg","删除失败");
        }
        String json = JSON.toJSONString(map);
        return json;
    }


    @RequestMapping("/addEdition")
    public String addEdition(HttpServletRequest request,HttpServletResponse response){
        String goodsId = request.getParameter("good_id");
        String editionName = request.getParameter("edition_name");
        EditionModel editionModel = new EditionModel();
        editionModel.setGoodId(goodsId);
        editionModel.setEditionName(editionName);
        EditionService editionService = new EditionService();
        int i = editionService.addEdition(editionModel);
        Map<String,String> map = new HashMap<>();
        if (i>0){
            map.put("retCode","1");
            map.put("retMsg","删除成功");
        }else {
            map.put("retCode","0");
            map.put("retMsg","删除失败");
        }
        String json = JSON.toJSONString(map);
        return json;
    }
}
