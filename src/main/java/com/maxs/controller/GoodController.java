package com.maxs.controller;

import com.alibaba.fastjson.JSONObject;
import com.maxs.model.GoodModel;
import com.maxs.service.GoodService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 11:36
 */
@RestController
@RequestMapping("/good")
public class GoodController {
    private GoodService goodService = new GoodService();

    /**
     * 〈获取所有的good表值〉
     * @Param: []
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 13:38
     */
    @RequestMapping("/list")
    public List<Map> listGood() {
        List<Map> list = goodService.listGoodAll();
        return list;
    }

    /**
     * 〈接受ID，返回对应ID的信息〉
     *
     * @Param: []
     * @Return: java.util.Map
     * @Author: WuGuo
     * @Date: 2019/9/26 12:43
     */
    @RequestMapping(path = "/get")
    @ResponseBody
    @PostMapping
    public List<Map> getName(HttpServletRequest request) {
        System.out.println(request.getParameter("goodID"));
        List<Map> list = goodService.getGood(request.getParameter("goodID"));
        return list;
    }

    @RequestMapping("/test")
    @ResponseBody
    @PostMapping
    public String getByJSON(@RequestBody JSONObject jsonParam){
        // 直接将json信息打印出来
        System.out.println(jsonParam.toJSONString());

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", jsonParam);

        return result.toJSONString();
    }

    /**
     * 〈接受ID，根据ID进行删除〉
     *
     * @Param: []
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:44
     */
    @RequestMapping("/remove")
    public Map remove(HttpServletRequest request) {
        return goodService.deleteC(request.getParameter("goodID"));
    }

    /**
     * 〈接受新增数据，返回添加结果，大于0成功〉
     *
     * @Param: [request]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:44
     */
    @RequestMapping("/save")
//    @ResponseBody
    public Map save(HttpServletRequest request) {
        GoodModel goodModel = putInGoodModel(request);
        return goodService.saveC(goodModel);
    }

    /**
     * 〈获取修改的内容以及修改目标ID〉
     *
     * @Param: [request]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:46
     */
    @RequestMapping("/update")
//    @ResponseBody
    public Map update(HttpServletRequest request) {
        GoodModel goodModel = putInGoodModel(request);
        goodModel.setGoodID(strTOInt(request.getParameter("goodID")));
        return goodService.updateC(goodModel);
    }

    /**
     * string转int，为null时，返回0
     *
     * @param str
     * @return
     */
    private int strTOInt(String str) {
        int i = 0;
        if (str != null && str != "") {
            i = Integer.parseInt(str);
        }
        return i;
    }

    /**
     * 〈将获取到的值放入GoodModel中〉
     *
     * @Param: [request]
     * @Return: com.maxs.model.GoodModel
     * @Author: WuGuo
     * @Date: 2019/9/26 12:45
     */
    private GoodModel putInGoodModel(HttpServletRequest request) {
        GoodModel goodModel = new GoodModel();
        goodModel.setGoodName(request.getParameter("goodName"));
        goodModel.setTypeID(strTOInt(request.getParameter("typeID")));
        goodModel.setTypeID(strTOInt(request.getParameter("channelID")));
        goodModel.setPrice(request.getParameter("price"));
        goodModel.setAdminID(strTOInt(request.getParameter("adminID")));
        goodModel.setCreateTime(request.getParameter("createTime"));
        goodModel.setUpdateTime(request.getParameter("updateTime"));
        goodModel.setHot(strTOInt(request.getParameter("hot")));
        goodModel.setHot(strTOInt(request.getParameter("banner")));
        return goodModel;
    }
}
