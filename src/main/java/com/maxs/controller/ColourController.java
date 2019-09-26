package com.maxs.controller;

import com.alibaba.fastjson.JSON;
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

    /**
     * 颜色表查询-----根据goodsId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getColour",method = RequestMethod.GET)
    public String getColour(HttpServletRequest request, HttpServletResponse response){
        String goodsID = request.getParameter("goodsId");
        ColourService colourService = new ColourService();
        List<Map> list=colourService.getColour(goodsID);
        String json = JSON.toJSONString(list);
        return json;
    }
}
