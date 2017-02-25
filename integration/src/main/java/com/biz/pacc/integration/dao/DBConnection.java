package com.biz.pacc.integration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
	public Connection getConnection() throws Exception
	{
	try
	{
	String connectionURL = "jdbc:mysql://192.168.3.99:3306/zadmin_epacchrms";		//202.83.17.66	tally_bizprout
	Connection connection = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	/*System.out.println("Class found");*/
	connection = DriverManager.getConnection(connectionURL, "epacc_hrms", "HTmNTVRqKqrBdVc6");
	/*System.out.println("Connection Established");*/
	return connection;
	}
	catch (SQLException e)
	{
	throw e;
	}
	catch (Exception e)
	{
	throw e;
	}
	}
public static void main(String args[]) throws Exception{
	DBConnection dbc= new DBConnection();
	dbc.getConnection();
}
}

