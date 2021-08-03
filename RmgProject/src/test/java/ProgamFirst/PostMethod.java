package ProgamFirst;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostMethod {

	@Test
	public void post() throws InterruptedException {

		JSONObject	jobj=new JSONObject();
		jobj.put("createdBy","GeethaN");
		jobj.put("projectName", "SDET8ghj");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 40);

		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.body(jobj);
		Response resp=reqSpec.post("http://localhost:8084/addProject");
		Thread.sleep(5000);
		resp.prettyPrint();
		//Assert.assertEquals(resp.getStatusCode(), 201);
		
		Assert.assertEquals(resp.getStatusCode(), 201);
	}
}
