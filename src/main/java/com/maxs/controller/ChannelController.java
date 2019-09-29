package com.maxs.controller;

import com.maxs.model.ChannelModel;
import com.maxs.service.ChannelService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-25 16:50
 */

@CrossOrigin
@RestController
@ResponseBody
@RequestMapping("/channel")
public class ChannelController {
    private ChannelService channelService = new ChannelService();

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
    public List<Map> getChannel(@RequestBody ChannelModel channel) {
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        System.out.println(channel.getChannelID());
        return channelService.getChannel(channel);
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
    public Map remove(@RequestBody ChannelModel channel) {
        long l = System.currentTimeMillis();
        channel.setUpdateTime(Long.toString(l));
        return channelService.deleteC(channel);
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
    public Map save(@RequestBody ChannelModel channel) {
        long l = System.currentTimeMillis();
        channel.setUpdateTime(Long.toString(l));
        return channelService.saveC(channel);
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
    public Map update(@RequestBody ChannelModel channel) {
        long l = System.currentTimeMillis();
        channel.setUpdateTime(Long.toString(l));
        channel.setCreateTime(Long.toString(l));
        return channelService.updateC(channel);
    }
}
