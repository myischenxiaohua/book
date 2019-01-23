/*
 ClassName:com.book.dao
 Description:
 User: myischenxiaohua@163.com
 Date: 2018-12-28
 Time: 22:38
 */
package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BaseDaoImpl {
    protected Connection conn;
    protected PreparedStatement pstmt;
    public BaseDaoImpl(Connection conn){
        this.conn=conn;
    }

    /**
     * 增、删、改操作
     *
     * @param sql
     *            sql语句
     * @param params
     *            参数数组
     * @return 执行结果
     * @throws SQLException
     */
    protected int executeUpdate(String sql, Object... params) throws SQLException {
            this.pstmt = this.conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                this.pstmt.setObject(i + 1, params[i]);
            }
       return this.pstmt.executeUpdate();


    }

    /**
     * 查询操作
     *
     * @param sql
     *            sql语句
     * @param params
     *            参数数组
     * @return 查询结果集
     * @throws SQLException
     */
    protected ResultSet executeQuery(String sql, Object... params) throws SQLException {
            this.pstmt = this.conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                this.pstmt.setObject(i + 1, params[i]);
            }
            return this.pstmt.executeQuery();

    }
}
