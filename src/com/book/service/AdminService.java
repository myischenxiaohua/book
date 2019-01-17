package com.book.service; /*
 ClassName:com.book.service.impl
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-08
 Time: 23:16
 */

import com.book.domian.Admin;

import java.util.Map;

public interface AdminService {
    /**
     * 实现管理员登录检查操作，调用AdminDAO接口中的checkLogin方法
     * @param vo 表示要操作的对象（name,password）
     * @return 成功返回true并且将最后一次登陆日期传递到页面，失败返回false
     * @throws Exception
     */
    boolean login(Admin vo) throws Exception;

    /**
     * 实现增加操作
     * @param vo
     * @return
     * @throws Exception
     */
    boolean insert(Admin vo) throws Exception;

    /**
     * 实现修改操作
     * @param vo
     * @return
     * @throws Exception
     */
    boolean edit(Admin vo) throws Exception;
    /**
     * 实现删除操作
     * @param id
     * @return
     * @throws Exception
     */
    boolean delById(int id) throws Exception;



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
