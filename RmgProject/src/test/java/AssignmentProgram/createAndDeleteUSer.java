package AssignmentProgram;
import static org.junit.Assert.assertThat;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
public class createAndDeleteUSer {
@Test
public void endToEndProgram() {
	JSONObject obj=new JSONObject();
	obj.put("createdBy","Kirthika");
	obj.put("projectName","Airtel2");
	obj.put("status","completed");
	obj.put("teamSize","12");
	
	Response response =given()
	.contentType(ContentType.JSON)
	.body(obj)	
	.when()
	.post("http://localhost:8084/addProject");
	
	 
	String	projName = response.jsonPath().get("projectName");
	 System.out.println(response.asPrettyString());
	 
	 when()
	 .post("http://localhost:8084/employee/{projectName}")
	.then()
	.log().all()
	 .assertThat().statusCode(201)
	 .assertThat().contentType(ContentType.JSON);
	 
		JSONObject Emp=new JSONObject();
		obj.put("designation","SDET");
		obj.put("dob","25/05/1999");
		obj.put("email","completed");
		obj.put("teamSize","12");
		
	
	
	
	
}

}
