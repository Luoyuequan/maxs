package com.maxs.common;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnMap {

    Map<String,String> map = new HashMap();
    public String getUpdateReMap(int i){

        if (i>0){
            map.put("status","1");
            map.put("msg","修改成功");
        }else {
            map.put("status","0");
            map.put("msg","修改失败");
        }
        String json = JSON.toJSONString(map);
        return json;
    }

    public String getdelReMap(int i){

        if (i>0){
            map.put("status","1");
            map.put("msg","删除成功");
        }else {
            map.put("status","0");
            map.put("msg","删除失败");
        }
        String json = JSON.toJSONString(map);
        return json;
    }

    public String getaddReMap(int i){

        if (i>0){
            map.put("status","1");
            map.put("msg","新增成功");
        }else {
            map.put("status","0");
            map.put("msg","新增失败");
        }
        String json = JSON.toJSONString(map);
        return json;
    }

    public String getGetReMap(List<Map> m){

        if (m.size()>0){
            map.put("status","1");
            map.put("msg","查询成功");
        }else {
            map.put("status","0");
            map.put("msg","查询失败");
        }
        m.add(map);
        String json = JSON.toJSONString(m);
        return json;
    }
}
