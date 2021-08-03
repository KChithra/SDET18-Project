package RequestChaining;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class ChainingProgram {
	@Test
	public void RequestChainingMethod() {
	baseURI="http://localhost";
	port=8084;
	//get all the project
	Response resp=when()
	.get("/projects");
	
	//capture any project ID
	String firstProjectId=resp.jsonPath().get("[0].projectId");
	System.out.println(firstProjectId);
	
	//delete that project
	given()
	.pathParam("ProjID",firstProjectId)
	.when()
	.delete("/projects/{ProjID}")
	.then()
	.assertThat().statusCode(204)
	.log().all();
		
		
		
	}
}
