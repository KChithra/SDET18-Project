package com.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Connection conn=null;
	/**
	 * This class contains generic methods related to database
	 * @author Chithra
	 *
	 */
	public void getConnection() throws Throwable {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		 conn = DriverManager.getConnection(IConstantsAndPath.dbUrl, IConstantsAndPath.dbUserName, IConstantsAndPath.dbPassword);	
	}
	/**
	 * close database connection
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable {
		
		conn.close();
	}
	/**
	 * 
	 *execute query 
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag=false;
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(expData);
		while(result.next()) {
			if(result.getString(columnIndex).equalsIgnoreCase(expData)) {
			flag=true;
			break;
			}
		}
		if(flag)
		{
			System.out.println(expData+"This data is present in database.");
			return  expData;
		}
		else
		{
			System.out.println(expData+"This data is not present in database.");
			return  expData;
		}
	}
	
	
}
