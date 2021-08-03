package AssignmentProgram;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class AssignementRmg7 {
@Test
public void Program7Rmg() {
	
	JSONObject obj=new JSONObject();
	obj.put("createdBy","Deepaa");
	obj.put("projectName","HoneyWorld33");
	obj.put("status","on-Going");
	obj.put("teamSize","85");
	
	given()
	.contentType(ContentType.JSON)
	.body(obj)
	.when()
	.post("http://localhost:8084/addProject")
	.then().log().all()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(201);
	
}
}
