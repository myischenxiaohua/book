package com.book.dao.impl; /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 11:39
 */

import com.book.dao.BooksDao;
import com.book.domian.Admin;
import com.book.domian.BookCase;
import com.book.domian.BookCategory;
import com.book.domian.Books;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                "extant,inventory,"+
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
        List<Books> books=new ArrayList<Books>();

        String sql= "select b.*, a.name admin,c.name category,bc.name bookcase from T_BOOKS b" +
                " left join T_ADMIN a on b.admin_id=a.id" +
                " left join T_BOOK_CATEGORY c on c.id=b.category_id"+
                " left join T_BOOKCASE bc on bc.id=b.bookcase_id"+
                " where b.inventory>0 and b."+column+" like ?"
                + " order by credate limit ?,?";
        ResultSet rst=super.executeQuery(sql, "%" + keyWord + "%", (currentPage - 1)*lineSize,lineSize);
        while (rst.next()){
            Books book=new Books();
            book.setIsbn(rst.getString("isbn"));
            book.setName(rst.getString("name"));
            book.setAuthor(rst.getString("author"));
            book.setPublish(rst.getString("publish"));
            book.setEdition(rst.getInt("edition"));
            book.setPublishDate(rst.getDate("publishdate"));
            book.setUnitprice(rst.getDouble("unitprice"));
            book.setCreatDate(rst.getDate("credate"));
            book.setExtant(rst.getInt("extant"));
            book.setInventory(rst.getInt("inventory"));
            book.setRemark(rst.getString("remark"));
            Admin admin =new Admin();
            admin.setName(rst.getString("admin"));
            admin.setId(rst.getInt("admin_id"));
            book.setAdmin(admin);
            BookCategory bookCategory=new BookCategory();
            bookCategory.setName(rst.getString("category"));
            book.setBookCategory(bookCategory);
            BookCase bookCase=new BookCase();
            bookCase.setName(rst.getString("bookcase"));
            book.setBookCase(bookCase);

            books.add(book);

        }

        return books;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "select count(name) num from T_BOOKS where ? like ?";
        ResultSet rst=super.executeQuery(sql, column,"%" + keyWord + "%");
        if(rst.next()){
            return rst.getInt("num");
        }
        return 0;

    }

    @Override
    public boolean findByName(String name) throws SQLException {
        String sql="select * from T_BOOKS where name=?";
        ResultSet rst=super.executeQuery(sql,name);
        if(rst.next()){
            return false;
        }
        return true;
    }
}
