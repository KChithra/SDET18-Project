package com.ParameterProgram;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParameter {
@Test
public void QueryAuthentication() {

	baseURI="https://reqres.in";
	
	given()
	.queryParam("page", 4)
	.when()
	.get("/api/users")
	.then().log().all()
	.assertThat().statusCode(200);
	
	
}
}
