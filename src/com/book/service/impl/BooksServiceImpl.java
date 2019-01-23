package com.book.service.impl; /*
 ClassName:com.book.service.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 14:41
 */

import com.book.dao.impl.BooksDaoImpl;
import com.book.domian.Books;
import com.book.service.BooksService;
import com.book.util.Database;

import java.sql.Connection;

public class BooksServiceImpl implements BooksService {
    private Database db=new Database();



    @Override
    public boolean insert(Books vo) throws Exception {
        if(new BooksDaoImpl(db.getConn()).findByName(vo.getName())){
            new BooksDaoImpl(db.getConn()).createData(vo);
            return  true;
        }
        return false;
    }
}
