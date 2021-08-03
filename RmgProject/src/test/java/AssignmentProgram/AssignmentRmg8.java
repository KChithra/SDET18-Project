package AssignmentProgram;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AssignmentRmg8 {
@Test
public void Program8rmg() {
	JSONObject	jobj=new JSONObject();
	jobj.put("createdBy","Farinaa");
	jobj.put("projectName", "GreenKingdom01");
	jobj.put("status", "Completed");
	jobj.put("teamSize", 45);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201)
	.assertThat().time(Matchers.lessThan(300L),TimeUnit.SECONDS)
	.log().all();
}

}
