package com.abstarct.factory.demo;

public class DaoFactoryProducer {

    public static DaoAbstractFactory produceFactory(String type) {
        DaoAbstractFactory daoAbstractFactory = null;
        if ("xml".equalsIgnoreCase(type)) {
            daoAbstractFactory = new XmlDaoFactory();
        } else if ("db".equalsIgnoreCase(type)) {
            daoAbstractFactory = new DbDaoFactory();
        }
        return daoAbstractFactory;
    }
}
