package com.gdpu.util;

import org.springframework.stereotype.Component;

/**
 * StringUtil
 * @description: 字符串工具类
 **/
@Component
public class StringUtil {

    /**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
