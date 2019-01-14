package com.book.util; /*
 ClassName:com.book.util
 Description:自定义工具类
 User: myischenxiaohua@163.com
 Date: 2019-01-15
 Time: 0:46
 */

import java.util.UUID;

public class WebUtils {
    public static String getUUID(){ //获取识别码
        return UUID.randomUUID().toString();
    }
}
