package com.book.dao.impl; /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 8:56
 */

import com.book.dao.BookCaseDao;
import com.book.domian.BookCase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookCaseDaoImpl extends BaseDaoImpl implements BookCaseDao {
    public BookCaseDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean createData(BookCase vo) throws SQLException {
        String sql="insert into T_BOOKCASE values(?,?)";
       int rel= super.executeUpdate(sql,vo.getId(),vo.getName());
        return rel>0;
    }

    @Override
    public boolean updateData(BookCase vo) throws SQLException {
        return false;
    }

    @Override
    public boolean removeData(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public BookCase findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<BookCase> findAll() throws SQLException {
        String sql="select * from T_BOOKCASE";
        ResultSet rst=super.executeQuery(sql);
        List<BookCase> list=new ArrayList<BookCase>();
        while (rst.next()){
            BookCase bookCase=new BookCase();
            bookCase.setId(rst.getInt("id"));
            bookCase.setName(rst.getString("name"));
            list.add(bookCase);
        }
        return list;
    }

    @Override
    public List<BookCase> findBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public boolean findByName(String name) throws SQLException {
        String sql="select * from T_BOOKCASE where name=?";
        ResultSet rst=super.executeQuery(sql,name);
        if (rst.next())return true;
        return false;
    }
}
