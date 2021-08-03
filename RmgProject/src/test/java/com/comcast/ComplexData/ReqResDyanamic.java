package com.comcast.ComplexData;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ReqResDyanamic {

	public class ReqResDynamicResponse {
		@Test
		public void dynamicResponse() {
		String expectedData="Funke";
		String actualData=null;
			
			Response response = when()
					.get("https://reqres.in/api/users?page=2");
					
					//verification of status code
					response.then()
					.statusCode(200).log().all();
					List<String> list=response.jsonPath().get("data[2].last_name");
				//	boolean flag=false;
					for (String data:list)
					{
						if(data.equals(expectedData))
						{
							actualData=data;
							//flag=true;
							break;
						}
					}
					//Assert.assertEquals(flag,true);
					Assert.assertEquals(actualData,expectedData);
					
		}}}

