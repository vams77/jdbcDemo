package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		  Connection con ;
	        Statement stmt;
	        ResultSet rs;
	        int cnt=0;
	        try {
	            // register JDBC driver
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            //open a connection 
	            System.out.println("Connection to database...");
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty123$");
	            
	            String sql = " DElete from candidates where rtrim(last_name) like \'Y%g\';";
	            System.out.println("  ");
	            stmt = con.createStatement();
	            cnt =  stmt.executeUpdate(sql);
	            
	            if ( cnt >0) {
	            	System.out.println(" record for young is deleted successfully ");
	            }
	            else 
	            {
	            	System.out.println("Record not found");
	            }
	            con.close();
	            
	            }
catch(Exception ce )
	        {
	System.out.println(ce);
	
	        }
	}

}
