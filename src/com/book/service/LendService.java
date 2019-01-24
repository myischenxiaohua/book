package com.book.service; /*
 ClassName:com.book.service
 Description:借阅服务
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 16:46
 */

import com.book.domian.LendBook;

import java.util.Map;

public interface LendService {
    /**
     * 实现数据增加操作
     * @param vo 表示要增加的借阅对象
     * @return
     * @throws Exception
     */
    boolean insert(LendBook vo) throws Exception;

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
