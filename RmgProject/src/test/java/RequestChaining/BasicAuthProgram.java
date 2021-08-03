package RequestChaining;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class BasicAuthProgram {

	@Test
	public void BasicAuthAuthentication() {
		baseURI="http://localhost";
		port=8084;
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().log().all()
		.assertThat().statusCode(202)
		.assertThat().contentType(ContentType.JSON);
		
		
	}
}
