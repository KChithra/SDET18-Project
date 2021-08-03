package ProgamFirst;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Get {
	@Test
	public void getAll()
	{
		Response resp=RestAssured.get("http://localhost:8084/projects");
		String respBody=resp.asString();
		System.out.println(respBody);
		//String prettyResp= resp.prettyPrint();
				//System.out.println(prettyResp);
		int aStCo=resp.getStatusCode();
		System.out.println(aStCo);
		Assert.assertEquals(aStCo, 200);
		String aCoTy=resp.getContentType();
		System.out.println(aCoTy);
		Assert.assertEquals(aCoTy, "application/json");
	}
	

}
