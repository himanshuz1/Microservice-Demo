package com.abstarct.factory.demo;

public class DbDeptDao implements Dao{
    @Override
    public void save() {
        System.out.println("saving department information in database");
    }
}
