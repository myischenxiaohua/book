package com.book.dao.impl; /*
 ClassName:com.book.dao.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 17:20
 */

import com.book.dao.LendBookDao;
import com.book.domian.LendBook;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class LendBookDapImpl extends BaseDaoImpl implements LendBookDao {
    public LendBookDapImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean createData(LendBook vo) throws SQLException {
        String sql="insert into  T_LEND_BOOK (reader_id,books_isbn,credate,retdate,renew_number) values (?,?,?,?,?)";
        int rel=super.executeUpdate(sql,vo.getReader().getId(),vo.getBook().getIsbn(),vo.getCredate(),vo.getRetdate(),vo.getRenewNumber());
        return rel>0;
    }

    @Override
    public boolean updateData(LendBook vo) throws SQLException {
        return false;
    }

    @Override
    public boolean removeData(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public LendBook findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<LendBook> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<LendBook> findBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
