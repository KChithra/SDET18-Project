package ProgramValidation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PostValidation {
	@Test
	public void createProject() {
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "Divya");
	jObj.put("projectName", "SDET_18_Project5");
	jObj.put("status", "on-Going");
	jObj.put("teamSize", "150");
	
	given()
	.contentType(ContentType.JSON)
	.body(jObj) // body part
	.when()
	 .post("http://localhost:8084/addProject") 
	 .then()
	 .log().all() 
	 .assertThat().statusCode(201)
	 .assertThat().contentType(ContentType.JSON);
		
	}

}
