package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

 
    public static void main(String[] args) {
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {
            // Register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");    
            //Open a connection
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty123$");
            
            //Execute a query
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from candidates");
            
            //Execute data from resultSet
            while(rs.next()) {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString("email"));
            }
            con.close();
        }
        catch(Exception e) {
            e.getMessage();
        }    

    }
}

 