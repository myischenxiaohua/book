package com.book.service; /*
 ClassName:com.book.service
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-23
 Time: 17:04
 */

import com.book.domian.BookCategory;

import java.util.List;

public interface BookCategoryService {
    /**
     * 实现分类的增加操作
     * @param vo 表示要执行的分类对象
     * @return 成功返回 true，失败返回 false
     * @throws Exception
     */
    public boolean insert(BookCategory vo) throws Exception;

    /**
     * 定义实现数据全部查询操作
     * @return
     * @throws Exception
     */
    public List<BookCategory> list() throws Exception;
}
