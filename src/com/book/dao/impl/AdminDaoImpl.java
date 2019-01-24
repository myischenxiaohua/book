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
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;


 public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

     @Override
     public boolean createData(Admin vo) throws SQLException {
         String sql = "insert into T_ADMIN (name,password,phone,flag) values(?,?,?,?)";
         int rel=super.executeUpdate(sql,vo.getName(),vo.getPassword(),vo.getPhone(),vo.getFlag());

//		 new java.sql.Timestamp(vo.getLastDate().getTime())

         return rel > 0;

     }

     @Override
     public boolean updateData(Admin vo) throws SQLException {
         String sql="update T_ADMIN set password=? ,phone=?,flag=?,status=? where id=?";
        int rel= super.executeUpdate(sql,vo.getPassword(),vo.getPassword(),vo.getPhone(),vo.getFlag(),vo.getStatus(),vo.getId());
         return rel>0;
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
     public boolean delById(int id) throws Exception {
         String sql ="delete from T_ADMIN where id=?";
         int rel=super.executeUpdate(sql,id);
         return rel>0;
     }

     @Override
     public List findAll() throws SQLException {
         List<Admin> list=new ArrayList<Admin>();
         String sql="select * from T_ADMIN";
         ResultSet rst= super.executeQuery(sql);
         while (rst.next()){
             Admin admin=new Admin();
             admin.setId(rst.getInt("id"));
             admin.setName(rst.getString("name"));
             admin.setPassword(rst.getString("password"));
             admin.setLastDate(rst.getTimestamp("lastdate"));
             admin.setFlag(rst.getShort("flag"));
             admin.setPhone(rst.getString("phone"));
             admin.setStatus(rst.getShort("status"));
             list.add(admin);

         }
         return list;
     }

     @Override
     public List<Admin> findBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
         List<Admin> admins=new ArrayList<Admin>();
         String sql= "select * from T_ADMIN where "+column+" like ?"
                 + " order by id limit ?,?";
         ResultSet rst=super.executeQuery(sql, "%" + keyWord + "%", (currentPage - 1)*lineSize,lineSize);
         while (rst.next()){
             Admin admin=new Admin();
             admin.setId(rst.getInt("id"));
             admin.setName(rst.getString("name"));
             admin.setPassword(rst.getString("password"));
             admin.setLastDate(rst.getTimestamp("lastdate"));
             admin.setFlag(rst.getShort("flag"));
             admin.setPhone(rst.getString("phone"));
             admin.setStatus(rst.getShort("status"));
             admins.add(admin);

         }

         return admins;
     }

     @Override
     public Integer getAllCount(String column, String keyWord) throws SQLException {
         String sql = "select count(name) num from T_ADMIN where ? like ?";
         ResultSet rst=super.executeQuery(sql, column,"%" + keyWord + "%");
         if(rst.next()){
             return rst.getInt("num");
         }
         return 0;
     }

     public AdminDaoImpl(Connection conn){
        super(conn);
    }
    @Override
    public boolean checkLogin(Admin admin) throws Exception {
        boolean flag=false;
        String sql = "select id,name,password,lastdate,flag,phone,status from T_ADMIN where name=? and password=? and status=1";
        ResultSet rst=super.executeQuery(sql, admin.getName(), admin.getPassword());
        if(rst.next()){
            flag=true;
            admin.setId(rst.getInt(1));
            admin.setName(rst.getString(2));
            admin.setPassword(rst.getString(3));
            admin.setLastDate(rst.getTimestamp(4));
            admin.setFlag(rst.getShort(5));
            admin.setPhone(rst.getString(6));
            admin.setStatus(rst.getShort(7));

        }
        return flag;
    }

    @Override
    public boolean updateByLastDate(String name) throws Exception {
        boolean flag = false;
        String sql = "update T_ADMIN set lastdate = ? where name = ?";
        //登陆成功后，使用当前日期为最后一次登陆日期
        int rel = super.executeUpdate(sql,new Timestamp(new Date().getTime()),name);
        if(rel > 0){
            flag = true;
        }
        return flag;
    }

}
