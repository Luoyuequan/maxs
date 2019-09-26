package com.maxs.controller;

import com.maxs.model.ChannelModel;
import com.maxs.service.ChannelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-25 16:50
 */

@RestController
@RequestMapping("/channel")
public class ChannelController {
    private ChannelService channelService = new ChannelService();

    @RequestMapping
    public String hello() {
        return "Channel!!!";
    }
//    @RequestMapping
//    public String a() {
//        return "aaa!!!";
//    }

    /**
     * 〈获取表中的所有值
     *
     * @Param: []
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 13:50
     */
    @RequestMapping("/list")
    public List<Map> listChannel() {
        List<Map> list = channelService.listChannel();
        return list;
    }

    /**
     * 〈接受ID查询对应的值〉
     *
     * @Param: []
     * @Return: java.util.Map
     * @Author: WuGuo
     * @Date: 2019/9/26 13:50
     */
    @RequestMapping("/get")
    public List<Map> getChannel(HttpServletRequest request) {
        String channelID = request.getParameter("channelID");
//        Map map = new HashMap();
        List<Map> list = null;
        if (channelID != null && channelID != "") {
            list = channelService.getChannel(Integer.parseInt(channelID));
        }
        return list;
    }

    /**
     * 〈根据ID删除对应消息〉
     *
     * @Param: []
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 13:51
     */
    @RequestMapping("/remove")
    public Map remove(HttpServletRequest request) {
        String channelID = request.getParameter("channelID");
        Map map = new HashMap();
        if (channelID != null && channelID != "") {
            map = channelService.deleteC(Integer.parseInt(channelID));
        }
        return map;
    }

    /**
     * 〈添加信息〉
     *
     * @Param: [request]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 13:51
     */
    @RequestMapping("/save")
    @ResponseBody
    public Map save(HttpServletRequest request) {

        ChannelModel channelModel = new ChannelModel();
        channelModel.setChannelName(request.getParameter("channelName"));
        channelModel.setCreateTime(request.getParameter("createTime"));
        channelModel.setUpdateTime(request.getParameter("updateTime"));
        String adminID = request.getParameter("adminID");
        if (adminID != null&&adminID!="") {
            channelModel.setAdminID(Integer.parseInt(adminID));
        }
        Map map = channelService.saveC(channelModel);
        return map;
    }

    /**
     * 〈根据ID修改信息，接受ID和修改部分的信息〉
     *
     * @Param: [request]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 13:51
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map update(HttpServletRequest request) {
        ChannelModel channelModel = new ChannelModel();
        channelModel.setChannelName(request.getParameter("channelName"));
        channelModel.setUpdateTime(request.getParameter("updateTime"));
        String adminID = request.getParameter("adminID");
        if (adminID != null&&adminID!="") {
            channelModel.setAdminID(Integer.parseInt(adminID));
        }
        String channelID = request.getParameter("channelID");
        if (channelID != null&&channelID!="") {
            channelModel.setChannelID(Integer.parseInt(channelID));
        }
        Map map = channelService.updateC(channelModel);
        return map;
    }
}
