package com.unitedcoder.regression.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

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
    public boolean getCustomer(String customerEmail, Connection connection) throws SQLException {
        boolean isCustomerExist = false;
        Statement statement = null; //equal to query
        ResultSet resultSet = null; //use data only during the connection with data base
        CachedRowSet cachedRowSet = null; //use data without connection
        cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        statement = connection.createStatement();
        String sqlScript = String.format("select customer_id, email " +
                "from cc_CubeCart_customer where email='%s'",customerEmail);
        System.out.println("query text is: "+ sqlScript);
        resultSet = statement.executeQuery(sqlScript);
        if (resultSet == null) {
            System.out.println("No records found");
            return isCustomerExist;
        } else {
            cachedRowSet.populate(resultSet); //fill out - populate
        }
        int count = 0;
        while (true) {
            if (!cachedRowSet.next()) {
                break;
            }
            int customerID = cachedRowSet.getInt("customer_id");
            String email = cachedRowSet.getString("email");
            System.out.println(String.format("customer_id=%d email=%s", customerID, email));
            count = cachedRowSet.getRow();
            System.out.println("Total rows: " + count);}
        if (count >= 1) {
            isCustomerExist=true;
        }
        return isCustomerExist;
    }
    public boolean insertNewCategory(CategoryObject categoryObject, Connection connection) throws SQLException {
        String insertQuery="insert into cc_CubeCart_category " +
                "(cat_name, cat_desc, cat_parent_id, cat_image, per_ship, " +
                "seo_meta_title, seo_meta_description, seo_meta_keywords, priority, status) " +
                "values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement insertStatement=null;
        insertStatement=connection.prepareStatement(insertQuery);
        insertStatement.setString(1,categoryObject.getCat_name());
        insertStatement.setString(2,categoryObject.getCat_desc());
        insertStatement.setInt(3,categoryObject.getCat_parent_id());
        insertStatement.setInt(4,categoryObject.getCat_image());
        insertStatement.setInt(5,categoryObject.getPer_ship());
        insertStatement.setString(6,categoryObject.getSeoMetaTitle());
        insertStatement.setString(7,categoryObject.getCat_desc());
        insertStatement.setString(8,categoryObject.getSeoMetaKeyword());
        insertStatement.setInt(9,categoryObject.getPriority());
        insertStatement.setInt(10,categoryObject.getStatus());

        int affectiveRow=0;
        affectiveRow=insertStatement.executeUpdate();
        if (affectiveRow>=1){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteCategory(String categoryName, Connection connection){
        String deleteQuery="delete from cc_CubeCart_category where cat_name=?";
        PreparedStatement deleteStatement=null;
        try {
            deleteStatement=connection.prepareStatement(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            deleteStatement.setString(1,categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int affectedRows=0;
        try {
            affectedRows=deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%d rows affected.",affectedRows));
        if (affectedRows>0){
            return true;
        }else
            return false;
    }

}
