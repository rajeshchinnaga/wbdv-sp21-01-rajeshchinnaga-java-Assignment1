package com.example.wbdvsp2101rajeshchinnagaserverjava.services;

import java.util.Date;

public class HelloObject {

    public Integer id;
    public String name;
    public Date today= new Date();

    public HelloObject(Integer id, String name, Date today) {
        this.id = id;
        this.name = name;
        this.today = today;
    }

    public HelloObject() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getToday() {
        return today;
    }
}
