package com.book.dao.impl; /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 16:37
 */

import com.book.dao.BookCategoryDao;
import com.book.domian.BookCase;
import com.book.domian.BookCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookCategoryDaoImpl extends BaseDaoImpl implements BookCategoryDao {
    public BookCategoryDaoImpl(Connection connection){
        super(connection);
    }


    @Override
    public boolean createData(BookCategory vo) throws SQLException {
        String sql="insert into T_BOOK_CATEGORY(pid,name,fine,remark) values(?,?,?,?)";
        int rel=super.executeUpdate(sql,vo.getPid(),vo.getName(),vo.getFine(),vo.getRemark());
        return rel>0;

    }

    @Override
    public boolean updateData(BookCategory vo) throws SQLException {
        return false;
    }

    @Override
    public boolean removeData(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public BookCategory findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<BookCategory> findAll() throws SQLException {
        String sql="select * from T_BOOK_CATEGORY";
        List<BookCategory> books=new ArrayList<BookCategory>();
        ResultSet rst=super.executeQuery(sql);
        while (rst.next()){
            BookCategory bookCategory=new BookCategory();
            bookCategory.setId(rst.getInt("id"));
            bookCategory.setPid(rst.getInt("pid"));
            bookCategory.setName(rst.getString("name"));
            bookCategory.setFine(rst.getDouble("fine"));
            bookCategory.setRemark(rst.getString("remark"));
            books.add(bookCategory);
        }
        return books;
    }

    @Override
    public List<BookCategory> findBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
