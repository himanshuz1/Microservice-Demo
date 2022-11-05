package com.abstarct.factory.demo;

public class DbEmpDao implements Dao {
    @Override
    public void save() {
        System.out.println("saving employee information in database");
    }
}
