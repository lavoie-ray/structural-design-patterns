package com.pluralsight.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcFacade 
{
	DbSingleton instance = null;
	
	public JdbcFacade()
	{
		instance = DbSingleton.getInstance();
	}
	
	public int createTable()
	{
		int count = 0;
		try
		{
			Connection conn = instance.getConnection();
			//System.out.println("createTable - conn: " + conn);
			Statement stmt = conn.createStatement();
			count = stmt.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int insertIntoTable()
	{
		int count = 0;
		try
		{
			Connection conn = instance.getConnection();
			//System.out.println("insertIntoTable - conn: " + conn);
			Statement stmt = conn.createStatement();
			count = stmt.executeUpdate("INSERT INTO Address (ID, StreetName, City) values (299, '2nd ave', 'Massapequa Park')");
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		
		return count;
	}
	
	public List<Address> getAddresses()
	{
		List<Address> addresses = new ArrayList<>();
		
		try
		{
			Connection conn = instance.getConnection();
			//System.out.println("getAddresses - conn: " + conn);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Address");
			
			while(rs.next())
				addresses.add(new Address(rs.getString(1), rs.getString(2), rs.getString(3)));
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		
		return addresses;
	}
}

class Address
{
	private String id;
	private String streetName;
	private String city;

	public Address(String id, String streetName, String city)
	{
		this.id = id;
		this.streetName = streetName;
		this.city = city;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
}