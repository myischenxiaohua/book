package com.book.service.impl; /*
 ClassName:com.book.service.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 9:08
 */

import com.book.dao.impl.BookCaseDaoImpl;
import com.book.domian.BookCase;
import com.book.service.ConfigService;
import com.book.util.Database;

import java.util.List;

public class ConfigServiceImpl implements ConfigService {
    private Database db =new Database();
    @Override
    public boolean insertBookCase(BookCase vo) throws Exception {
        if(new BookCaseDaoImpl(db.getConn()).findByName(vo.getName())) {
            new BookCaseDaoImpl(db.getConn()).createData(vo);
            return true;
        }
        return false;
    }

    @Override
    public List<BookCase> getBookCaseList() throws Exception {
        return new BookCaseDaoImpl(db.getConn()).findAll();

    }
}
