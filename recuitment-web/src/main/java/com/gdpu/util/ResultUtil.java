package com.gdpu.util;

import com.gdpu.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResultUtil {

    public Map<String, Object> successResult(String message) {
        return new HashMap(){{
            put("status", 200);
            put("message", message);
        }};
    }
    public Map<String, Object> successResult(String message, Object data) {
        return new HashMap(){{
            put("status", 200);
            put("message", message);
            put("data", data);
        }};
    }

    public Map<String, Object> customResult(Integer status, String message) {
        return new HashMap(){{
            put("status", status);
            put("message", message);
        }};
    }
    public Map<String, Object> customResult(Integer status, String message, Object data) {
        return new HashMap(){{
            put("status", status);
            put("message", message);
            put("data", data);
        }};
    }
    public Map<String, Object> userResult(Integer status, String message, Object user) {
        return new HashMap(){{
            put("status", status);
            put("message", message);
            put("user", user);
        }};
    }
    public Map<String, Object> customResult(Integer status, String message, Object data,String username,Integer id) {
        return new HashMap(){{
            put("status", status);
            put("message", message);
            put("data", data);
            put("username",username);
            put("userid",id);
        }};
    }

    public Map<String, Object> customResult(Integer status, String message,String username,Integer id) {
        return new HashMap(){{
            put("status", status);
            put("message", message);
            put("username",username);
            put("userid",id);
        }};
    }

    public Map<String, Object> customResult(Integer status, String message, Object data,String username,Integer id,Integer companyid) {
        return new HashMap(){{
            put("status", status);
            put("message", message);
            put("data", data);
            put("username",username);
            put("userid",id);
            put("companyid",companyid);
        }};
    }

}
