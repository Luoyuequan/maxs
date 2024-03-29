package com.maxs.controller;

import com.maxs.model.GoodInfoModel;
import com.maxs.service.GoodInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 13:07
 */
@CrossOrigin
@RestController
@ResponseBody
@RequestMapping("/goodInfo")
public class GoodInfoController {
    private GoodInfoService goodInfoService = new GoodInfoService();

    /**
     * 〈获取good_info表中的所有值〉
     *
     * @Param: []
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 13:23
     */
    @RequestMapping("/list")
    public List<Map> listGoodInfo() {
        List<Map> list = goodInfoService.listGoodInfo();
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
    @RequestMapping("/get")
    @PostMapping
    public List<Map> getGoodInfo(@RequestBody GoodInfoModel goodInfo) {
        return goodInfoService.getGoodInfo(goodInfo);
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
    @PostMapping
    public Map remove(@RequestBody GoodInfoModel goodInfo) {
        return goodInfoService.deleteC(goodInfo);
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
    @PostMapping
    public Map save(@RequestBody GoodInfoModel goodInfo) {
        return goodInfoService.saveC(goodInfo);
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
    @PostMapping
    public Map update(@RequestBody GoodInfoModel goodInfo) {
        return goodInfoService.updateC(goodInfo);
    }

}
