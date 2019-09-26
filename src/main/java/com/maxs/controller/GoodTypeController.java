package com.maxs.controller;

import com.maxs.model.GoodTypeModel;
import com.maxs.service.GoodTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goodType")
public class GoodTypeController {
    /**
     * 所有商品分类信息
     *
     * @param request 请求
     * @return 所有商品分类信息集
     */
    @RequestMapping(value = "/listAllInfo", method = RequestMethod.POST)
    public List<Map> listAllInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        GoodTypeService goodTypeService = new GoodTypeService();
        return goodTypeService.listAllInfo();
    }

    /**
     * 添加商品分类
     *
     * @param request 请求
     * @return 添加结果信息
     */
    @RequestMapping(value = "/addGoodType", method = RequestMethod.POST)
    public List<Map> addGoodType(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        String typeName = request.getParameter("typeName") == null ? "" : request.getParameter("typeName");
        int parentId = request.getParameter("parentId") == null ? 0 : Integer.parseInt(request.getParameter("parentId"));
        int adminId = request.getParameter("admintId") == null ? 0 : Integer.parseInt(request.getParameter("adminId"));
        String createTime = String.valueOf(System.currentTimeMillis());
        GoodTypeModel goodTypeModel = new GoodTypeModel();
        goodTypeModel.setTypeName(typeName);
        goodTypeModel.setParentId(parentId);
        goodTypeModel.setAdminId(adminId);
        goodTypeModel.setCreateTime(createTime);
        GoodTypeService goodTypeService = new GoodTypeService();
        return goodTypeService.addGoodType(goodTypeModel);
    }

    /**
     * 删除指定商品分类
     * 更改状态码
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/deleteGoodType", method = RequestMethod.POST)
    public List<Map> deleteGoodType(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int goodTypeId = request.getParameter("goodTypeId") == null ? 0 : Integer.parseInt(request.getParameter("goodTypeId"));
        int status = 2;
        GoodTypeModel goodTypeModel = new GoodTypeModel();
        goodTypeModel.setGoodTypeId(goodTypeId);
        goodTypeModel.setStatus(status);
        GoodTypeService goodTypeService = new GoodTypeService();
        return goodTypeService.deleteGoodType(goodTypeModel);
    }

    /**
     * 修改指定商品分类
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/updateGoodTypeInfo", method = RequestMethod.POST)
    public List<Map> updateGoodTypeInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int goodTypeId = request.getParameter("goodTypeId") == null ? 0 : Integer.parseInt(request.getParameter("goodTypeId"));
        String typeName = request.getParameter("typeName") == null ? "" : request.getParameter("typeName");
        int parentId = request.getParameter("parentId") == null ? 0 : Integer.parseInt(request.getParameter("parentId"));
        int adminId = request.getParameter("admintId") == null ? 0 : Integer.parseInt(request.getParameter("adminId"));
        String updateTime = String.valueOf(System.currentTimeMillis());
        GoodTypeModel goodTypeModel = new GoodTypeModel();
        goodTypeModel.setGoodTypeId(goodTypeId);
        goodTypeModel.setTypeName(typeName);
        goodTypeModel.setParentId(parentId);
        goodTypeModel.setAdminId(adminId);
        goodTypeModel.setUpdateTime(updateTime);
        GoodTypeService goodTypeService = new GoodTypeService();
        return goodTypeService.updateGoodTypeInfo(goodTypeModel);
    }
}
