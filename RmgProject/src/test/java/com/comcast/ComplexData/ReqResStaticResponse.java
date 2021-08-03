package com.comcast.ComplexData;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ReqResStaticResponse {
	@Test
	public void ReqResStatic() {
	
	
		String expectedData="michael.lawson@reqres.in";
		
		Response response = when()
		.get("https://reqres.in/api/users?page=2");
		
		response.then()
		.statusCode(200).log().all();
		
		String actualData=response.jsonPath().get("data[0].email");
		System.out.println("Expected data is :"+expectedData);
		System.out.println("actual data is :"+actualData);
		
		Assert.assertEquals(actualData,expectedData);
		
		
		
	}

}
