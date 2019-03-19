package com.book.service.impl; /*
 ClassName:com.book.service.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 9:02
 */

import com.book.dao.impl.ReaderDaoImpl;
import com.book.domian.Reader;
import com.book.service.ReaderService;
import com.book.util.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderServiceImpl implements ReaderService {
    private Database db=new Database();
    @Override
    public boolean insert(Reader vo) throws Exception {
        try {
            if(new ReaderDaoImpl(db.getConn()).findById(vo.getCard())==null){
                new ReaderDaoImpl(db.getConn()).createData(vo);
                return true;
            }

        }catch (Exception e){
            throw e;
        } finally{
            this.db.close();
        }


        return false;
    }

    @Override
    public List<Reader> list() throws Exception {
        try{
            return new ReaderDaoImpl(this.db.getConn()).findAll();
        } catch(Exception e){
            throw e;
        } finally{
            this.db.close();
        }
    }

    @Override
    public Map<String, Object> listBySplit(String column, String keyword, int currentPage, int lineSize) throws Exception {
        Map<String,Object> map=null;
        try{
            map=new HashMap<String, Object>();
            map.put("readers",new ReaderDaoImpl(db.getConn()).findBySplit(column,keyword,currentPage,lineSize));
            map.put("recordSize",new ReaderDaoImpl(db.getConn()).getAllCount(column,keyword));
        } catch(Exception e){
            throw e;
        } finally{
            this.db.close();
        }
        return map;
    }
}
