package com.pluralsight.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton 
{
	private static DbSingleton instance = null;
	private Connection conn = null;
	private String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
	
	private DbSingleton()
	{
		try 
		{
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());		
		} 
		catch (SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public static DbSingleton getInstance() 
	{
		
		if (instance == null)
		{
			synchronized(DbSingleton.class)
			{
				if (instance == null)
					instance = new DbSingleton();
			}
		}
		
		return instance;
	}
	
	public Connection getConnection()
	{
		if (conn == null)
		{
			synchronized(DbSingleton.class)
			{
				if (conn == null)
				{
					try
					{
						conn = DriverManager.getConnection(dbUrl);
						
						System.out.println("got connection");
					}
					catch(SQLException e)
					{
						System.out.println(e);
						e.printStackTrace();
					}
				}
			}
		}
		else
		{
			try
			{
				if (conn.isClosed())
				{
					conn = DriverManager.getConnection(dbUrl);
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
		
		return conn;
	}
}