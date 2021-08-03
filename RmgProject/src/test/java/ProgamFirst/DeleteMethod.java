package ProgamFirst;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteMethod {
	@Test

	public void deleteProject() {
		
		Response resp=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_802");
		String	respbody=resp.asString();
		System.out.println(respbody);
		
		int acturalResult=resp.getStatusCode();
		System.out.println(acturalResult);
		Assert.assertEquals(acturalResult, 204);
		
		String actualContentType=resp.getContentType();
		System.out.println(actualContentType);
		Assert.assertEquals(actualContentType, "application/json");
		
		
	
	}
}
