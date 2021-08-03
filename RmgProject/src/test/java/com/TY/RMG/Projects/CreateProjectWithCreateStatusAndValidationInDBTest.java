package com.TY.RMG.Projects;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateProjectWithCreateStatusAndValidationInDBTest {
	@Test
	public void CreateProjectWithCreateStatusAndValidationInDBTest() throws Throwable {
		baseURI="http://localhost";
		port=8084;
		//create project with created status using Pojo class
		ProjectLibrary projectLibrary=new ProjectLibrary("vamsi","OwnLand","Created",88);

		Response response=given()
				.contentType(ContentType.JSON)
				.body(projectLibrary)
				.when()
				.post("/addProject");

		//capture the project id
		String firstProjectId = response.jsonPath().get("projectId");
		String actualStatus = response.jsonPath().getString("status");
		System.out.println(firstProjectId);

		//verify the projects ID in the dataBase
		//Step1: register the DB
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		//Step 2: get connection with the DB
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projects", "root", "root");
		
		//Step 3: issue Create statement
		Statement statement = conn.createStatement();
		
		//Step 4: Execute Query
		ResultSet result=statement.executeQuery("select * from project");
		String expData=null;
		String expStatus=null;
		while(result.next())
		{
			if(result.getString(1).equals(firstProjectId)) {
			expData=result.getString(1);
			expStatus=result.getString(1);
			System.out.println("Project ID is sucessfully verified in the DB");
			System.out.println("Status is sucessfully verified in the DB");
			break;
			}
			
		}
		
		
		Assert.assertEquals(expData,firstProjectId);
		//close DB
		conn.close();
		
	}

}
