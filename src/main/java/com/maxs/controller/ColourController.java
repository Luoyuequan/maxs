package com.maxs.controller;

import com.maxs.dao.IColourDao;
import com.maxs.dao.impl.ColorImpl;
import com.maxs.model.ColourModel;
import com.maxs.service.ColourService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class ColourController {

    @RequestMapping("/getColour")
    public List<Map> getColour(HttpServletRequest request, HttpServletResponse response){
        ColourService colourService = new ColourService();
        List<Map> list=colourService.getColour();

        return list;
    }
}
