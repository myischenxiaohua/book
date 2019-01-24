package com.book.dao.impl; /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-22
 Time: 22:23
 */

import com.book.dao.BaseDao;
import com.book.dao.ReaderDao;
import com.book.domian.Reader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReaderDaoImpl extends BaseDaoImpl implements ReaderDao {
    public ReaderDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean createData(Reader vo) throws SQLException {
        String sql="insert into T_READER (id,name,age,card,sex,phone,createdate) values(?,?,?,?,?,?,?)";
        int rel=super.executeUpdate(sql,vo.getId(),vo.getName(),vo.getAge(),vo.getCard(),vo.getSex(),vo.getPhone(),vo.getCreateDate());

        return rel>0;
    }

    @Override
    public boolean updateData(Reader vo) throws SQLException {
        return false;
    }

    @Override
    public boolean removeData(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Reader findById(String card) throws SQLException {
        Reader reader=null;
        String sql="select id,name,age,card,sex,phone,violation_no,borrow_book_number,createDate from T_READER where card=?";
        ResultSet rst=super.executeQuery(sql,card);
        if (rst.next()){
            reader.setId(rst.getInt("id"));
            reader.setName(rst.getString("name"));
            reader.setAge(rst.getInt("age"));
            reader.setCard(rst.getString("card"));
            reader.setSex(rst.getShort("sex"));
            reader.setPhone(rst.getString("phone"));
            reader.setViolationNo(rst.getInt("violation_no"));
            reader.setBorrowBookNumber(rst.getInt("borrow_book_number"));
            reader.setCreateDate(rst.getDate("createDate"));
        }
        return reader;
    }

    @Override
    public List<Reader> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Reader> findBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Reader> list=new ArrayList<Reader>();
        String sql= "select * from T_READER " +
                " where "+column+" like ?"
                + " order by createDate limit ?,?";
        ResultSet rst=super.executeQuery(sql, "%" + keyWord + "%", (currentPage - 1)*lineSize,lineSize);

        while (rst.next()){
            Reader reader=new Reader();
            reader.setId(rst.getInt("id"));
            reader.setName(rst.getString("name"));
            reader.setAge(rst.getInt("age"));
            reader.setCard(rst.getString("card"));
            reader.setSex(rst.getShort("sex"));
            reader.setPhone(rst.getString("phone"));
            reader.setViolationNo(rst.getInt("violation_no"));
            reader.setBorrowBookNumber(rst.getInt("borrow_book_number"));
            reader.setCreateDate(rst.getDate("createDate"));
            list.add(reader);
        }

        return list;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "select count(name) num from T_READER where ? like ?";
        ResultSet rst=super.executeQuery(sql, column,"%" + keyWord + "%");
        if(rst.next()){
            return rst.getInt("num");
        }
        return 0;

    }
}
