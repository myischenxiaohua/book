package com.book.domian; /*
 ClassName:com.book.domian
 Description:读者表
 User: myischenxiaohua@163.com
 Date: 2019-01-22
 Time: 8:49
 */

import java.util.Date;
import java.util.List;

public class Reader {
    private int id;
    private String name;
    private int age;
    private String card;
    private short sex;
    private String phone;
    private int violationNo;
    private int borrowBookNumber;
    private Date createDate;
    private List<Books> books;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getViolationNo() {
        return violationNo;
    }

    public void setViolationNo(int violationNo) {
        this.violationNo = violationNo;
    }

    public int getBorrowBookNumber() {
        return borrowBookNumber;
    }

    public void setBorrowBookNumber(int borrowBookNumber) {
        this.borrowBookNumber = borrowBookNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }


}
