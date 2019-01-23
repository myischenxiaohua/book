package com.book.dao.impl; /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 11:39
 */

import com.book.dao.BooksDao;
import com.book.domian.Books;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class BooksDaoImpl extends BaseDaoImpl implements BooksDao {
    public BooksDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean createData(Books vo) throws SQLException {
        String sql="insert into T_BOOKS ("+
                "isbn,name," +
                "category_id,bookcase_id,"+
                "admin_id,author," +
                "publish,edition," +
                "publishdate,unitprice," +
                "extant,inventory"+
                "credate,remark) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int rel=super.executeUpdate(sql,vo.getIsbn(),vo.getName(),
                vo.getCategoryId(),vo.getBookcaseId(),vo.getAdminId(),vo.getAuthor(),
                vo.getPublish(),vo.getEdition(),vo.getPublishDate(),vo.getUnitprice(),
                vo.getExtant(),vo.getInventory(),vo.getCreatDate(),vo.getRemark()
        );
        return rel>0;
    }

    @Override
    public boolean updateData(Books vo) throws SQLException {
        return false;
    }

    @Override
    public boolean removeData(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Books findById(String name) throws SQLException {

        return null;
    }

    @Override
    public List<Books> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Books> findBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public boolean findByName(String name) throws SQLException {
        Books books=null;
        String sql="select * from T_Books where name=?";
        ResultSet rst=super.executeQuery(sql,name);
        if(rst.next()){
            return true;
        }
        return false;
    }
}
