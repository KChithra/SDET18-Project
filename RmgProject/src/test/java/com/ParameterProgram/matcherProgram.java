package com.ParameterProgram;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class matcherProgram {

	@Test
	public void pathAuthentication() {
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("projectId","TY_PROJ_1212")
		.when()
		.delete("/projects/{projectId}")
		.then()
		.assertThat().statusCode(204)
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS)
		.log().all();
		
	
	}
}
