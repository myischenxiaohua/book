package com.book.domian; /*
 ClassName:com.book.domian
 Description:借书记录
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 15:48
 */

import java.util.Date;

public class LendBook {
    private int id;
    private Reader reader;
    private Books book;
    private Date credate;
    private Date retdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Date getRetdate() {
        return retdate;
    }

    public void setRetdate(Date retdate) {
        this.retdate = retdate;
    }

    public int getRenewNumber() {
        return renewNumber;
    }

    public void setRenewNumber(int renewNumber) {
        this.renewNumber = renewNumber;
    }

    private int renewNumber;
}
