package ProgramPojo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;

public class CreateProjectUsingPojo {
	

	@Test
	public void CreatePojo() {
		ProjectLibrary	ProjL=new ProjectLibrary("GYTest1", "kkanu", "Completed", 28);
		given()
		.contentType(ContentType.JSON)
		.body(ProjL)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
		
		
		
		
		
	}
	
	
}
