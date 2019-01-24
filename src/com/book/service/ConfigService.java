package com.book.service; /*
 ClassName:com.book.service
 Description:配置管理服务
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 8:47
 */

import com.book.domian.BookCase;

import java.util.List;

public interface ConfigService {
    /**
     * 实现数据增加操作
     * @param vo 表示要增加的书架对象
     * @return
     * @throws Exception
     */
    boolean insertBookCase(BookCase vo) throws Exception;
    /**
     * 定义实现数据全部查询操作
     * @return
     * @throws Exception
     */
   List<BookCase> getBookCaseList() throws Exception;
}
