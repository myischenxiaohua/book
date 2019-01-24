package com.book.service; /*
 ClassName:com.book.service
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 14:35
 */

import com.book.domian.Books;

import java.util.Map;

public interface BooksService {
    /**
     * 实现数据增加操作
     * @param vo 表示要增加的书籍对象
     * @return
     * @throws Exception
     */
    boolean insert(Books vo) throws Exception;

    boolean updateExtant(Books vo) throws Exception;

    /**
     * 调用分页接口类
     * @param column 列名
     * @param keyword 查询关键字
     * @param currentPage 当前页
     * @param lineSize 每页的记录数
     * @return
     * @throws Exception
     */
    public Map<String, Object> listBySplit(String column, String keyword, int currentPage, int lineSize) throws Exception;
}
