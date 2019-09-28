package com.maxs.controller;

import com.maxs.common.RequestIsJson;
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
    private GoodTypeService goodTypeService = new GoodTypeService();
    private GoodTypeModel goodTypeModel;
    private Class claszz = GoodTypeModel.class;
    private RequestIsJson<GoodTypeModel> requestIsJson = new RequestIsJson<>();
    /**
     * 所有商品分类信息
     *
     * @param request 请求
     * @return 所有商品分类信息集
     */
    @RequestMapping(value = "/listAllInfo", method = RequestMethod.POST)
    public List<Map> listAllInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
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
        String createTime = String.valueOf(System.currentTimeMillis());
        goodTypeModel = requestIsJson.getJsonToModel(request,claszz);
        goodTypeModel.setCreateTime(createTime);
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
        int status = 2;
        goodTypeModel = requestIsJson.getJsonToModel(request,claszz);
        goodTypeModel.setStatus(status);
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
        String updateTime = String.valueOf(System.currentTimeMillis());
        goodTypeModel = requestIsJson.getJsonToModel(request,claszz);
        goodTypeModel.setUpdateTime(updateTime);
        return goodTypeService.updateGoodTypeInfo(goodTypeModel);
    }
}
