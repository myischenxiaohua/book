package com.book.service.impl; /*
 ClassName:com.book.service.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 17:06
 */

import com.book.dao.impl.BookCategoryDaoImpl;
import com.book.domian.BookCategory;
import com.book.service.BookCategoryService;
import com.book.util.Database;

import java.util.List;

public class BookCategoryServiceImpl implements BookCategoryService {
    private Database db =new Database();
    @Override
    public boolean insert(BookCategory vo) throws Exception {
        try{
            if(new BookCategoryDaoImpl(this.db.getConn()).createData(vo))return true;
        } catch(Exception e){
            throw e;
        } finally{
            this.db.close();
        }
        return false;
    }

    @Override
    public List<BookCategory> list() throws Exception {
        try{
            return new BookCategoryDaoImpl(this.db.getConn()).findAll();
        } catch(Exception e){
            throw e;
        } finally{
            this.db.close();
        }

    }
}
