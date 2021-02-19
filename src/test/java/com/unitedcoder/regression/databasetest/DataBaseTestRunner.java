package com.unitedcoder.regression.databasetest;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseTestRunner {
    static String dbURL="148.72.106.125";
    static String dbPort="3306";
    static String userName="testautomation";
    static String password="automation123!";
    static String defaultSchema="i4296639_cc1";
    Connection connection=null;

    @BeforeClass
    public void setup(){
        connection=ConnectionManager.connectToDataBaseServer(
                dbURL,dbPort,userName,password,defaultSchema,ConnectionType.MYSQLSERVER);
    }

    @Test(description = "CubCart inventory table")
    public void verifyProducts() throws SQLException {
        DataAccess access=new DataAccess();
        boolean isProductFound=access.getProductName("Toyota",connection);
        Assert.assertTrue(isProductFound);
    }

    @AfterClass
    public void tearDown(){
        ConnectionManager.closeDataBaseConnection(connection);
    }
}
