package com.book.service; /*
 ClassName:com.book.service
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 14:35
 */

import com.book.domian.Books;

public interface BooksService {
    /**
     * 实现数据增加操作
     * @param vo 表示要增加的书籍对象
     * @return
     * @throws Exception
     */
    boolean insert(Books vo) throws Exception;
}
