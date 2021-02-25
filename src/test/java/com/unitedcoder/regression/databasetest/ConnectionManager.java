package com.unitedcoder.regression.databasetest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // create a method to connect database
    public static Connection connectToDataBaseServer(String dbURL, String dbPort,
                                                     String dbUserName, String dbPassword, String defaultDataBase,
                                                     ConnectionType connectionType)
    {
        Connection connection = null;
        String JTDS_Driver = "net.sourceforge.jtds.jdbc.Driver"; //SQL
        String MYSQL_Driver = "com.mysql.cj.jdbc.Driver"; //MYSQL
        switch (connectionType) {
            case MSSQLSERVER:
//                Class.forName(JTDS_Driver); // load the SQL driver into memory
                String connectionURL="jdbc:jtds:sqlserver://" + dbURL + ":"
                        + "databaseName=" + defaultDataBase;
//                connection= DriverManager.getConnection(connectionURL,dbUserName,dbPassword);
                try {
                    connection= DriverManager.getConnection(connectionURL,dbUserName,dbPassword);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case MYSQLSERVER:
//                Class.forName(MYSQL_Driver).newInstance();
                try {
                    Class.forName(MYSQL_Driver).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                String mySqlConnection="jdbc:mysql://"+dbURL+":"+dbPort+"/"+defaultDataBase;
                try {
                    connection=DriverManager.getConnection(mySqlConnection,dbUserName,dbPassword);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                System.out.println("you need to specify data base connection type(MSSQL OR MYSQL)");
        }
        //verify if the connection is established or not
        try {
            if (!connection.isClosed()){
                System.out.println("database connection is established.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void closeDataBaseConnection(Connection connection){
        try {
            if (connection.isClosed()){
                System.out.println("Data base connection has been closed.");
            }else {
                connection.close();
                System.out.println("Connection is closed.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
