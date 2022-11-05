package com.abstarct.factory.demo;

public class XmlDaoFactory extends DaoAbstractFactory {
    @Override
    public Dao getDataAccessObject(String type) {
        Dao dao = null;
        if (type.equalsIgnoreCase("dept")) {
            dao = new XmlDeptDao();
        } else if ("emp".equalsIgnoreCase(type)) {
            dao = new XmlEmpDao();
        }
        return dao;
    }
}
