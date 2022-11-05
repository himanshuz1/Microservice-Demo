package com.abstarct.factory.demo;

public class XmlEmpDao implements Dao {
    @Override
    public void save() {
        System.out.println("saving employee information in XML data source");
    }
}
