package com.maxs.controller;

import com.maxs.common.RequestIsJson;
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
    ColourModel colourModel;
    private Class claszz = ColourModel.class;
    private RequestIsJson<ColourModel> requestIsJson = new RequestIsJson<>();
    /**
     * 根据goodsId查询手机有的颜色
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getColour",method = RequestMethod.POST)
    public String getColour(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        colourModel = requestIsJson.getJsonToModel(request, claszz);
        List<Map> list=colourService.getColour(colourModel.getGoodsId());
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
        colourModel = requestIsJson.getJsonToModel(request, claszz);
        int i = colourService.delColour(colourModel.getColourId());
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
        colourModel = requestIsJson.getJsonToModel(request, claszz);
        int i = colourService.addColour(colourModel);
        return returnMap.getaddReMap(i);
    }
}
