 /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-03
 Time: 22:20
 */
 package com.book.dao.impl;
import com.book.dao.AdminDao;
import com.book.dao.BaseDao;
import com.book.domian.Admin;

import java.sql.Connection;
import java.sql.ResultSet;


public class AdminImpl extends BaseDao implements AdminDao {


    @Override
    public Admin login(Admin vo) throws Exception {
        String sql = "select id,name,password,flag,phone,status from T_ADMIN where name=? and password=? and status=1";
        ResultSet rst=super.executeQuery(sql, new Object[]{vo.getName(), vo.getPassword()});
        if(rst.next()){
            vo.setId(rst.getInt(1));
            vo.setName(rst.getString(2));
            vo.setPassword(rst.getString(3));
            vo.setFlag(rst.getShort(4));
            vo.setPhone(rst.getString(5));
            vo.setStatus(rst.getShort(6));
        }
        return vo;
    }

    @Override
    public boolean updateById(String id) throws Exception {
        return false;
    }

}
