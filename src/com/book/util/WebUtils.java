package com.book.util; /*
 ClassName:com.book.util
 Description:自定义工具类
 User: myischenxiaohua@163.com
 Date: 2019-01-15
 Time: 0:46
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class WebUtils {
    //获取识别码

    public static String getUUID(){ //获取识别码
        return UUID.randomUUID().toString();
    }
    /**
     * 验证数据是否为空
     * @param data 要执行验证的数据
     * @return 数据为空返回false
     */
    public static boolean validateEmpty(String data){
        if(data == null || "".equals(data)){
            return false;
        }
        return true;
    }
    //转换date 至String
    public static String formatString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    //转换String 到 date
    public static Date formatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date_=null;
        try {
            date_=sdf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date_;
    }
    //将util的date转换成sql的date"yyyy-MM-dd"
    public static java.sql.Date utilToSql(Date date){
        return new java.sql.Date(date.getTime());
    }

}
