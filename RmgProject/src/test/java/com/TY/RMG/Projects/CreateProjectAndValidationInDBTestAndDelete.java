package com.TY.RMG.Projects;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProjectAndValidationInDBTestAndDelete {
@Test	
public void CreateDataBaseAndDelete() throws Throwable  {
	baseURI="http://localhost";
	port=8084;
	
	Response response=when()
			.get("/projects");

	String firstProjectId1 = response.jsonPath().get("[0].projectId");
	System.out.println(firstProjectId1);

	Driver driver = new Driver();
	DriverManager.registerDriver(driver);

	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projects", "root", "root");
	
	Statement statement = conn.createStatement();
	
	ResultSet result=statement.executeQuery("select * from project");
	String expData=null;
	
	while(result.next())
	{
		if(result.getString(1).equals(firstProjectId1)) 
		{
		expData=result.getString(1);
		System.out.println("Project ID is sucessfully verified in DB");
		break;
		}	
	}
	
	Assert.assertEquals(expData,firstProjectId1);
	
	when()
	.delete("/projects/"+firstProjectId1)
	.then().log().all()
	.assertThat().statusCode(204)
	.assertThat().contentType(ContentType.JSON);
	
	while(result.next())
	{
		if(!(result.getString(1).equals(firstProjectId1)))
		{
			System.out.println("project ID sucessfully delected from DB");
			break;
		}
		
	}
	
	
	
	
	
	
	
	
	
}
	

}
