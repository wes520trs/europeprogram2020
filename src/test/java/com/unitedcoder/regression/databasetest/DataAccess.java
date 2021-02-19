package com.unitedcoder.regression.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    // get product information
    public boolean getProductName(String productName, Connection connection) throws SQLException {
        boolean isProductExist = false;
        Statement statement = null; //equal to query
        ResultSet resultSet = null; //use data only during the connection with data base
        CachedRowSet cachedRowSet = null; //use data without connection
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            statement = connection.createStatement();
        String sqlScript = String.format("select product_id, name, price " +
                "from cc_CubeCart_inventory where name='%s'",productName);
        System.out.println("query text is: "+ sqlScript);
            resultSet = statement.executeQuery(sqlScript);
        if (resultSet == null) {
            System.out.println("No records found");
            return isProductExist;
        } else {
                cachedRowSet.populate(resultSet); //fill out - populate
        }
        int count = 0;
        while (true) {
                if (!cachedRowSet.next()) {
                    break;
                }
        int productID = cachedRowSet.getInt("product_id");
        String name = cachedRowSet.getString("name");
        double price = cachedRowSet.getDouble("price");
        System.out.println(String.format("product_id=%d name=%s price=%.2f",
                productID, name, price));
        count = cachedRowSet.getRow();
        System.out.println("Total rows: " + count);}
        if (count >= 1) {
            isProductExist=true;
        }
        return isProductExist;
    }
}
