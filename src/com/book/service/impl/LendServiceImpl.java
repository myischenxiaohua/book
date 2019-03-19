package com.book.service.impl; /*
 ClassName:com.book.service.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 17:30
 */

import com.book.dao.impl.LendBookDaoImpl;
import com.book.domian.LendBook;
import com.book.service.LendService;
import com.book.util.Database;

import java.util.Map;

public class LendServiceImpl implements LendService {
    private Database db=new Database();
    @Override
    public boolean insert(LendBook vo) throws Exception {
       if(new LendBookDaoImpl(db.getConn()).createData(vo)) return true;
        return false;
    }

    @Override
    public Map<String, Object> listBySplit(String column, String keyword, int currentPage, int lineSize) throws Exception {
        return null;
    }
}
