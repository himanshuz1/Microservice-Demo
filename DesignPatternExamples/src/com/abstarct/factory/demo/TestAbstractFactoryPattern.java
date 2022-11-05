package com.abstarct.factory.demo;

public class TestAbstractFactoryPattern {

    public static void main(String[] args) {
        DaoFactoryProducer.produceFactory("xml").getDataAccessObject("emp").save();
    }
}
