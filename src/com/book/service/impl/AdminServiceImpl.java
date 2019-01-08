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

public class AdminServiceImpl implements AdminService {
    private Database db=new Database();
    @Override
    public boolean login(Admin vo) throws Exception {

        try{
            if(new AdminDaoImpl(db.getConn()).checkLogin(vo)){
                return new AdminDaoImpl(db.getConn()).updateByLastDate(vo.getName());
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
}
