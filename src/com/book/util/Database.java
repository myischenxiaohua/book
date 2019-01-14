 /*
 ClassName:com.book.util
 Description:
 User: myischenxiaohua@163.com
 Date: 2018-12-10
 Time: 22:43
 */
package com.book.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DRIVER = ConfigManager.getProperty("driverClass");// 数据库驱动字符串
    private static final String URL = ConfigManager.getProperty("url");// 连接URL字符串
    private static final String USER = ConfigManager.getProperty("user"); // 数据库用户名
    private static final String PASSWORD = ConfigManager.getProperty("password"); // 用户密码
    private Connection conn = null;
    public Database(){ //构造器
        try {
            //加载驱动
            Class.forName(DRIVER);
            //创建数据库连接
            this.conn=DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConn() {
        return this.conn;
    }

    /**
     * 关闭数据库连接
     */
    public void close(){
        if(this.conn != null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
