package com.maxs.common;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

public class RequestIsJson<T> {
    public T getJsonToModel(HttpServletRequest request,Class claszz) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream input = request.getInputStream();
            int n;
            while ((n = input.read()) != -1) {
                sb.append((char) n);
            }
            if (sb.length() == 0){
                sb.append("{}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) JSON.parseObject(sb.toString(), claszz);
    }
}
