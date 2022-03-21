package com.ldblao.cv360.components;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
public class ResponseHelper {
    public HashMap<String, Object> success(Object data, String message)throws Exception{
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("status","00");
        hashMap.put("message",message);
        hashMap.put("dataResponse",data);
        return hashMap;
    }
    public HashMap<String, Object> failed(Object data, String message)throws Exception{
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("status","05");
        hashMap.put("message",message);
        hashMap.put("dataResponse",data);
        return hashMap;
    }
}
