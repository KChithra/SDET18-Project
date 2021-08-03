package AssignmentProgram;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AssignmentChainingRequest {
	@Test
	public void RequetChainingProgram() {
		//Project Created
		HashMap map = new HashMap();
		map.put("createdBy", "WiFi");
		map.put("projectName", "JPVBuilders");
        map.put("status", "On-Going");
		map.put("teamSize", 80);
		
		 Response response = given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/addProject");
		 
		//Deleted the Project  
		String getName = response.jsonPath().get("projectId");
		System.out.println(response.asPrettyString());
		System.out.println(getName);
	
		when()
		.delete("http://localhost:8084/projects/" +getName)
		.then()
		.log().all()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON);
			
		
		
	}	
}

