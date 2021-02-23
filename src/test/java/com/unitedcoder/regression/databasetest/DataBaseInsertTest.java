package com.unitedcoder.regression.databasetest;

import com.unitedcoder.configutility.ApplicationConfig;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseInsertTest {
    static String configFile="config.properties";
    static String standAloneURL= ApplicationConfig.readConfigProperties(configFile,"standAlone.dbURL");
    static String dbPort=ApplicationConfig.readConfigProperties(configFile,"standAlone.dbPort");
    static String userName=ApplicationConfig.readConfigProperties(configFile,"standAlone.userName");
    static String password=ApplicationConfig.readConfigProperties(configFile,"standAlone.password");
    static String defaultSchema=ApplicationConfig.readConfigProperties(configFile,"standAlone.defaultSchema");
    Connection connection=null;

    @BeforeClass
    public void setup(){
        connection=ConnectionManager.connectToDataBaseServer(
                standAloneURL,dbPort,userName,password,defaultSchema,ConnectionType.MYSQLSERVER);
    }

    @Test(description = "Admin user should able to insert record into cubecart category table")
    public void verifyCategoryInsertTest() throws SQLException {
       CategoryObject categoryObject=new CategoryObject("Tursun_MySQL","My_SQL_demo1",
               1,0,1, 1, 0,
               "demo", "description","keyword");
       DataAccess access=new DataAccess();
       boolean isRecordInserted=access.insertNewCategory(categoryObject,connection);
       Assert.assertTrue(isRecordInserted);
    }


    @AfterClass
    public void tearDown(){
        ConnectionManager.closeDataBaseConnection(connection);
    }
}
