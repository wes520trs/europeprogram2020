package com.unitedcoder.regression.homework.sprint5;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DataBaseAction {

    Connection myConn;
    TestDataHolder dataHolder;

    @BeforeClass
    public void ConnectToDataBase() {
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://148.72.106.125:3306/i4296639_cc1",
                    "testautomation", "automation123!");
            Statement myStmt = myConn.createStatement();
            if (!myConn.isClosed()) {
                System.out.println("Data connection is established.");
            } else {
                System.out.println("Data base connection is failed to build.");
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @Test
    public void getCustomersInfo() throws SQLException {
        boolean isCustomerExist = false;
        Statement statement = null; //equal to query
        ResultSet resultSet = null; //use data only during the connection with data base
        CachedRowSet cachedRowSet = null; //use data without connection
        cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        statement = myConn.createStatement();
        String sqlScript = "select customer_id, first_name, last_name, email " +
                "from cc_CubeCart_customer where first_name like 'Tursun161%';";
        System.out.println("query text is: " + sqlScript);
        resultSet = statement.executeQuery(sqlScript);
        System.out.println("String value of resultSet: " + resultSet.toString());
        System.out.println("row nomber of resultSet: " + resultSet.getRow());
        System.out.println("getType of resultSet: " + resultSet.getType());
        if (resultSet == null) {
            System.out.println("No records found");
        } else {
            cachedRowSet.populate(resultSet); //fill out - populate
            System.out.println("String of cachedRowSet: " + cachedRowSet.toString());
            System.out.println("Collection of cachedRowSet: " + cachedRowSet.toCollection());
        }
        int count = 0;
        while (true) {
            if (!cachedRowSet.next()) {
                break;
            }
            int customerID = cachedRowSet.getInt("customer_id");
            String firstName = cachedRowSet.getString("first_name");
            String lastName = cachedRowSet.getString("last_name");
            String email = cachedRowSet.getString("email");
            System.out.println(String.format("customerID=%d firstName=%s lastName=%s email=%s",
                    customerID, firstName, lastName, email));
            count = cachedRowSet.getRow();
            System.out.println("first name from dataholder is: "+
                    "\n first name from cachedRoeSet is: "+firstName);
//            Assert.assertEquals(firstName,dataHolder.getFirstName());
        }
        System.out.println("Total rows: " + count);
    }


    @AfterClass
    public void closeDataBaseConnection() {
        try {
            if (myConn.isClosed()) {
                System.out.println("Data base connection has been closed.");
            } else {
                myConn.close();
                System.out.println("Connection is closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
