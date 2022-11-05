package com.abstarct.factory.demo;

public class XmlDeptDao implements Dao{
    @Override
    public void save() {
        System.out.println("saving department information in XML data source");
    }
}
