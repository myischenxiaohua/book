package com.book.dao; /*
 ClassName:com.book.dao
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 11:34
 */

import com.book.domian.Books;

import java.sql.SQLException;

public interface BooksDao extends BaseDao<String, Books> {
    boolean findByName(String name) throws SQLException;//根据书籍查询该书籍是否存在
    /**
     * 更新现存量
     * @param isbn 要更新的用户名
     * @return
     * @throws Exception
     */
    boolean updateExtant(String isbn,Integer extant) throws Exception;
}
