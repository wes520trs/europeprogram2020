package com.unitedcoder.regression.databasetest;

import java.sql.Connection;

public class DataBaseConnectionTest {
    static String dbURL="148.72.106.125";
    static String dbPort="3306";
    static String userName="testautomation";
    static String password="automation123!";
    static String defaultSchema="i4296639_cc1";

    public static void main(String[] args) {
        Connection connection=ConnectionManager.connectToDataBaseServer(
                dbURL,dbPort,userName,password,defaultSchema,ConnectionType.MYSQLSERVER);
        ConnectionManager.closeDataBaseConnection(connection);
    }
}
