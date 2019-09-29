package com.maxs.common;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestIsJson<T> {
    public T getJsonToModel(HttpServletRequest request, Class claszz) {
        StringBuilder buffer = new StringBuilder();
        Reader reader = null;
        try {
            reader = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
            int n = 0;
            while ((n = reader.read()) != -1) {
                buffer.append((char) n);
            }
            if (buffer.length() == 0) {
                return (T) claszz.newInstance();
            }
        } catch (IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return (T) JSON.parseObject(buffer.toString(), claszz);
    }
}
