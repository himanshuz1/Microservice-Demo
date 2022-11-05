package com.abstarct.factory.demo;

public class DbDaoFactory extends DaoAbstractFactory {
    @Override
    public Dao getDataAccessObject(String type) {
        Dao dao = null;
        if (type.equalsIgnoreCase("dept")) {
            dao = new DbDeptDao();
        } else if ("emp".equalsIgnoreCase(type)) {
            dao = new DbEmpDao();
        }
        return dao;
    }
}
