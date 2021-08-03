package AssignmentProgram;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class AssignmentRmg9 {
@Test
public void Program9rmg() {
	JSONObject obj=new JSONObject();
	obj.put("createdBy","rmg");
	obj.put("createdOn","26/05/2021");
	obj.put("projectID","ProjID_253");
	obj.put("projectName", "rmgProject22");
	obj.put("status","Created");
	obj.put("teamSize","10");
	
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
