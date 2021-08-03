package com.comcast.ComplexData;
import static io.restassured.RestAssured.*;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import junit.framework.Assert;
public class ValidateDynamicResponseTest {
	@Test
	public void dynamicResponse() {
	String expectedData="Deepak";
	String actualData=null;
		
		Response response = when()
				.get("http://localhost:8084/projects");
				
				//verification of status code
				response.then()
				.statusCode(200).log().all();
				List<String> list=response.jsonPath().get("createdBy");
				boolean flag=false;
				for (String data:list)
				{
					if(data.equals(expectedData))
					{
						actualData=data;
						flag=true;
						break;
					}
				}
				Assert.assertEquals(flag,true);
				Assert.assertEquals(actualData,expectedData);
				
		
	}
}
