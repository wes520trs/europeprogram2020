package com.unitedcoder.regression.databasetest;


import java.sql.Connection;

public class ConnectionManager {
    // create a method to connect database
    public static Connection connectToDataBaseServer(String dburl, String dbPort,
                                                     String dbUserName, String dbPassword, String defaultDataBase,
                                                     ConnectionType connectionType) {
        Connection connection = null;
        String JTDS_Driver = "net.sourceforge.jtds.jdbc.Driver"; //SQL
        String MYSQL_Driver = "com.mysql.cj.jdbc.Driver"; //MYSQL
        switch (connectionType) {
            case MSSQLSERVER:
//                Class.forName(JTDS_Driver);
                try {
                    Class.forName(JTDS_Driver);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
        }return connection;
    }
}
