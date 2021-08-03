package ProgramValidation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetValidation {
@Test
public void getAllProject(){
	When()
	.get("http://localhost:8084/projects")
	.then()
	.log().all()
	.and()
	.assertThat().statusCode(200)
	.and()
	.assertThat().contentType(ContentType.JSON);
	
	
}

private RestAssured When() {
	// TODO Auto-generated method stub
	return null;
}
}
