package com.ParameterProgram;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PathProgram {

	@Test
	public void pathAuthentication() {
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("projectId","TY_PROJ_1207")
		.when()
		.delete("/projects/{projectId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	
	}
	}
