package com.maxs.controller;

import com.maxs.common.JDBC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @RequestMapping("/getT")
    public List<Map> getT(){
        String username="";
        String sql="select * from admin";
        List<Map> list= JDBC.excuteQuery(sql);
        System.out.println(list);
        return list;
    }
}
