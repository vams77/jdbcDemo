package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class ScrollableDemo {

	public static void main(String[] args) {
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {
            // Register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");    
            //Open a connection
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty123$");
            
//SCROLLABLE RESULTSET
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            
            rs=stmt.executeQuery("select * from skills");
            
            // readinf from bottom top 
            rs.afterLast();
            while(rs.previous()) {
            	System.out.println(rs.getInt(1)+ " "+rs.getString(2));
            }
            
            System.out.println("***************************");
            // move the cursor to 3rd record
            rs.absolute(3);
            
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
            System.out.println("*****************************");
            
            //move the cursor to 2nd record using relative()
            
            rs.relative(-1);
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
            System.out.println("*******************************");
            
            int i =rs.getRow();
            System.out.println("cursor position "+i);
            
            // cleanup
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
        	System.out.println(e);
           
            
	

}
	}
	
}
