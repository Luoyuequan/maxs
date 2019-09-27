package com.maxs.controller;

import com.maxs.common.ReturnMap;
import com.maxs.model.ColourModel;
import com.maxs.service.ColourService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class ColourController {
    ReturnMap returnMap = new ReturnMap();
    ColourService colourService = new ColourService();
    ColourModel colourModel = new ColourModel();
    /**
     * 根据goodsId查询手机有的颜色
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getColour",method = RequestMethod.POST)
    public String getColour(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域

        String goodsID = request.getParameter("goodsId");
        List<Map> list=colourService.getColour(goodsID);
        return returnMap.getGetReMap(list);
    }

    /**
     * 删除颜色
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delColor",method = RequestMethod.POST)
    public String delColour(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        String colourId = request.getParameter("colour_id");
        int i = colourService.delColour(colourId);
        return returnMap.getdelReMap(i);
    }

    /**
     * 添加color
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addColor",method = RequestMethod.POST)
    public String addColour(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        String goodId = request.getParameter("goodId");
        String colourName = request.getParameter("colourName");
        String colourUrl = request.getParameter("colourUrl");
        colourModel.setGoodsId(goodId);
        colourModel.setColourUrl(colourName);
        colourModel.setColourName(colourUrl);
        int i = colourService.addColour(colourModel);
        return returnMap.getaddReMap(i);
    }
}
