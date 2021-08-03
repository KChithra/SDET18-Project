package ProgramMapper;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import java.io.File;


import io.restassured.http.ContentType;

public class FileJson {
	@Test
	public void FileNew()
	{
	File f=new File("./Sample.json");
	given()
	.contentType(ContentType.JSON)
	.body(f)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.log().all()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON);
	
	}

}
