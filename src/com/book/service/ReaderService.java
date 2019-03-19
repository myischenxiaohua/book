package com.book.service; /*
 ClassName:com.book.service
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 8:57
 */

import com.book.domian.Reader;

import java.util.List;
import java.util.Map;

public interface ReaderService {
    /**
     * 实现数据增加操作
     * @param vo 表示要增加的读者对象
     * @return
     * @throws Exception
     */
    boolean insert(Reader vo) throws Exception;
    /**
     * 定义实现数据全部查询操作
     * @return
     * @throws Exception
     */
    List<Reader> list() throws Exception;

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
