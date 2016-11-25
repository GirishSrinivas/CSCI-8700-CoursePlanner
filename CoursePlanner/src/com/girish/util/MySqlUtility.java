package com.girish.util;

import java.sql.*;

public class MySqlUtility 
{
	static String url = "jdbc:mysql://localhost:3306/course_planner?autoReconnect=true&useSSL=false";
	static String usr = "root";
	static String pwd = "root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);
		}
		catch(ClassNotFoundException e)
		{
			throw new ClassNotFoundException("Unable to load the class");
		}
		catch (SQLException e) 
		{
			throw new SQLException("Unable to connect to database....");
		}
		
		return con;
	}
	
	public static void closeConnection(Connection con) throws SQLException
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			throw new SQLException("Unable to close connection to database....");
		}
	}
}
