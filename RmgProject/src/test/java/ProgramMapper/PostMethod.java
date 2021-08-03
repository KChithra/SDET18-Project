package ProgramMapper;

import java.util.HashMap;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class PostMethod {

	@Test
	public void getHash() {
		
	HashMap	hmap=new HashMap();
	hmap.put("createBy", "Navya");
	hmap.put("projectName", "Green85");
	hmap.put("status", "on-Going");
	hmap.put("teamSize", 25);
	
	given()
	.contentType(ContentType.JSON)
	.body(hmap)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.log().all()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON);
	
	
	
		
	}
}
