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
}
