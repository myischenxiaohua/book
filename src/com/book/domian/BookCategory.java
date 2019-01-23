package com.book.domian; /*
 ClassName:com.book.domian
 Description:图书分类表
 User: myischenxiaohua@163.com
 Date: 2019-01-22
 Time: 8:33
 */

import java.util.List;

public class BookCategory {
    private int id;
    private int pid;
    private String name;
    private  double fine;
    private  String remark;
    private List<Books> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }


}
