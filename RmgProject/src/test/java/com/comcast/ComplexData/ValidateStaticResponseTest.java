package com.comcast.ComplexData;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
public class ValidateStaticResponseTest {

	@Test
	public void ValidateStatic() {
	
		//expected data initialization
		String expectedData="Manual_selenium";
		
		// getting the resource from the server_1st Step
		Response response = when()
		.get("http://localhost:8084/projects");
		
		//verification of status code
		response.then()
		.statusCode(200).log().all();
		
		//capture the specific data from response body
		String actualData=response.jsonPath().get("[1].projectName");
		System.out.println("Expected data is :"+expectedData);
		System.out.println("actual data is :"+actualData);
		
		//Testng assertion for actual & expected data
		Assert.assertEquals(actualData,expectedData);
		
		
		
	}
}
