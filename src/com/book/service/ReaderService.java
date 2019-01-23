package com.book.service; /*
 ClassName:com.book.service
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 8:57
 */

import com.book.domian.Reader;

public interface ReaderService {
    /**
     * 实现数据增加操作
     * @param vo 表示要增加的读者对象
     * @return
     * @throws Exception
     */
    boolean insert(Reader vo) throws Exception;
}
