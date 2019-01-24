package com.book.domian; /*
 ClassName:com.book.domian
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-24
 Time: 15:59
 */

import java.util.Date;

public class GiveBack {
    private int id;
    private Reader reader;

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

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    private Books book;
    private Date backTime;
}
