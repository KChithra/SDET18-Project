package ProgamFirst;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethod {
	@Test
	public void post() {

		JSONObject	jobj=new JSONObject();
		jobj.put("createdBy","deepak_pro-2");
		jobj.put("projectName", "SDET18_ghm");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 30);
	
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);
		Response resp=reqSpec.put("http://localhost:8084/projects/TY_PROJ_804");
		resp.prettyPrint();
		
		Assert.assertEquals(resp.getContentType(), 200);
		
	
	}

}
