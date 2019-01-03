 /*
 ClassName:com.book.domian
 Description:管理员实体类
 User: myischenxiaohua@163.com
 Date: 2019-01-03
 Time: 21:40
 */
package com.book.domian;
public class Admin {
    private int id;
    private String name;
    private String password;
    private short flag;
    private String phone;
    private short status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getFlag() {
        return flag;
    }

    public void setFlag(short flag) {
        this.flag = flag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }


}
