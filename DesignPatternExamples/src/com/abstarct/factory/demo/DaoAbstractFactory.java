package com.abstarct.factory.demo;

public abstract class DaoAbstractFactory {
    public abstract Dao getDataAccessObject(String type);
}
