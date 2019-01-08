 /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-03
 Time: 22:20
 */
 package com.book.dao.impl;
import com.book.dao.AdminDao;
import com.book.domian.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;


 public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

     @Override
     public boolean createData(Admin vo) throws SQLException {
         String sql = "insert into admin(name,password,status) values(?,?,?)";
         int rel=super.executeUpdate(sql,new Object[]{vo.getName(),vo.getPassword(),vo.getStatus()});

//		 new java.sql.Timestamp(vo.getLastDate().getTime())

         return rel > 0;

     }

     @Override
     public boolean updateData(Admin vo) throws SQLException {
         return false;
     }

     @Override
     public boolean removeData(Set ids) throws SQLException {
         return false;
     }

     @Override
     public Admin findById(String id) throws SQLException {
         Admin vo = null;
         String sql = "select id,name,password,lastdate,phone,flag,status from T_ADMIN where name = ?";
         ResultSet rs = super.executeQuery(sql,id);
         if(rs.next()){
             vo = new Admin();
             vo.setId(rs.getInt("id"));
             vo.setFlag(rs.getShort("flag"));
             vo.setStatus(rs.getShort("status"));
             vo.setPassword(rs.getString("password"));
             vo.setLastDate(rs.getTimestamp("lastdate"));
             vo.setPhone(rs.getString("phone"));
         }
         return vo;
     }

     @Override
     public List findAll() throws SQLException {
         return null;
     }

     @Override
     public List findBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
         return null;
     }

     @Override
     public Integer getAllCount(String column, String keyWord) throws SQLException {
         return null;
     }

     public AdminDaoImpl(Connection conn){
        super(conn);
    }
    @Override
    public boolean checkLogin(Admin vo) throws Exception {
        boolean flag=false;
        String sql = "select id,name,password,flag,phone,status from T_ADMIN where name=? and password=? and status=1";
        ResultSet rst=super.executeQuery(sql, new Object[]{vo.getName(), vo.getPassword()});
        if(rst.next()){
            flag=true;
            vo.setId(rst.getInt(1));
            vo.setName(rst.getString(2));
            vo.setPassword(rst.getString(3));
            vo.setFlag(rst.getShort(4));
            vo.setPhone(rst.getString(5));
            vo.setStatus(rst.getShort(6));
        }
        return flag;
    }

    @Override
    public boolean updateByLastDate(String name) throws Exception {
        boolean flag = false;
        String sql = "update T_ADMIN set lastdate = ? where name = ?";
        //登陆成功后，使用当前日期为最后一次登陆日期
        int rel = super.executeUpdate(sql,new Object[]{new Timestamp(new Date().getTime()),name});
        if(rel > 0){
            flag = true;
        }
        return flag;
    }

}
