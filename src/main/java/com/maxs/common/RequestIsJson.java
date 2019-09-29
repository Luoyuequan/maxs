package com.maxs.common;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestIsJson<T> {
    public T getJsonToModel(HttpServletRequest request, Class claszz) {
//        字节流 一个字节读  中文无影响
/*        List<Byte> arr = new ArrayList<>();
        byte[] buffer = new byte[1];
        int n;
        while ((n = input.read(buffer)) != -1) {
            arr.add(buffer[0]);
        }
        byte[] bytes = new byte[ arr.size()];
        for (int index = 0; index < arr.size(); index++) {
            bytes[index] = arr.get(index);
        }
        System.out.println(new String(bytes));*/
//         字符流 一个字符读 中文无影响
        StringBuilder buffer = new StringBuilder();
        Reader reader = null;
        try {
            reader = new InputStreamReader(request.getInputStream());
            char[] chars = new char[1024];
            int n = 0;
            while ((n = reader.read(chars)) != -1) {
                buffer.append(new String(chars, 0, n));
            }
            System.out.println(buffer.toString());
            if (buffer.length() == 0) {
                Constructor cn = claszz.getConstructor();
                return (T) cn.newInstance();
            }
        } catch (IOException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
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
