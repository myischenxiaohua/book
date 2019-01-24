package com.book.dao; /*
 ClassName:com.book.dao
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 8:54
 */

import com.book.domian.BookCase;

import java.sql.SQLException;

public interface BookCaseDao extends BaseDao<String, BookCase> {
    boolean findByName(String name)throws SQLException;;
}
