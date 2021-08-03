package AssignmentProgram;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class AssignmentRequestChaining {
	@Test
	public void RequetChainingProgram() {
		//Created the Project  
		HashMap map = new HashMap();
		map.put("createdBy", "kini");
		map.put("projectName", "LMU_Project");
        map.put("status", "Completed");
		map.put("teamSize", 28);
		
		 Response response = given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/addProject");
		
		 // Get the Project
		 String	projId = response.jsonPath().get("projectId");
		 System.out.println(response.asPrettyString());
		 
	 when()
		 .get("http://localhost:8084/projects/" +projId)
		 .then()
		 .log().all()
		 .assertThat().statusCode(200)
		 .assertThat().contentType(ContentType.JSON);
	 
	//Deleted the Project  
	 when()
		.delete("http://localhost:8084/projects/" +projId)
		.then()
		.log().all()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON);
		
		
		
		
	}
}
