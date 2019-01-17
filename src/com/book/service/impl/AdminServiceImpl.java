package com.book.service.impl; /*
 ClassName:com.book.service.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-08
 Time: 23:28
 */

import com.book.dao.impl.AdminDaoImpl;
import com.book.domian.Admin;
import com.book.service.AdminService;
import com.book.util.Database;

import java.util.HashMap;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    private Database db=new Database();

    @Override
    public boolean login(Admin admin) throws Exception {

        try{
            if(new AdminDaoImpl(db.getConn()).checkLogin(admin)){
                return new AdminDaoImpl(db.getConn()).updateByLastDate(admin.getName());
            }
            return false;
        } catch(Exception e){
            throw e;
        } finally{
            db.close();//最后一定要关闭数据库连接
        }
    }

    @Override
    public boolean insert(Admin vo) throws Exception {
        try{
            if(new AdminDaoImpl(db.getConn()).findById(vo.getName()) == null){
                new AdminDaoImpl(db.getConn()).createData(vo);
                return true;
            }
        } catch(Exception e){
            throw e;
        } finally{
            this.db.close();
        }
        return false;
    }

    @Override
    public boolean edit(Admin vo) throws Exception {
        if(new AdminDaoImpl(db.getConn()).updateData(vo)){
            return true;
        }
        return false;
    }

    @Override
    public boolean delById(int id) throws Exception {
        if(new AdminDaoImpl(db.getConn()).delById(id)){
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> listBySplit(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        Map<String, Object> map = null;
        try{
        map = new HashMap<String, Object>();
        map.put("admins",new AdminDaoImpl(db.getConn()).findBySplit(column, keyWord, currentPage, lineSize));
        map.put("recordSize",new AdminDaoImpl(db.getConn()).getAllCount(column, keyWord));
        } catch(Exception e){
            throw e;
        } finally{
            this.db.close();
        }
        return map;
    }

}
