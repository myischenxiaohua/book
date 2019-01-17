package com.book.dao; /*
 ClassName:com.book.dao
 Description:
 User: myischenxiaohua@163.com
 Date: 2018-12-28
 Time: 22:33
 */

import com.book.domian.Admin;

public interface AdminDao extends BaseDao<String, Admin> {

    /**
     * 实现用户登录检查操作
     * @param vo 表示要执行检查的对象（id,password,flag）
     * @return 成功返回 ture,失败返回 false
     * @throws Exception
     */
    public boolean checkLogin(Admin vo) throws Exception;

    /**
     * 实现用数据更新操作
     * @param name 要更新的用户名
     * @return
     * @throws Exception
     */
    public boolean updateByLastDate(String name) throws Exception;

    public  boolean delById(int id) throws Exception;

}
