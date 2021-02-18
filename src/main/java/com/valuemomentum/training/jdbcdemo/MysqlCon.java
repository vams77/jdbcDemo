package com.valuemomentum.training.jdbcdemo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MysqlCon {

	
	public static void main( String[] args )
	{
		Connection con ;
		Statement stmt;
		ResultSet rs;
		
		try {
			// register JDBC driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//open a connection 
			System.out.println("Connection to database...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Qwerty123$");
			
			
			//create a statement object using connection object 
			stmt= con.createStatement();
			
			//execute a query and retrieve the data into resultset
			rs=stmt.executeQuery("select * from employees");
			
			//Extract data from result set
			
			while (rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
				+" "+rs.getString("email")+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getString(8));
	        }
			
		
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
 