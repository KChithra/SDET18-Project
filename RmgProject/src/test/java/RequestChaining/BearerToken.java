package RequestChaining;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken {
@Test
public void BearerProgram() {
	
	baseURI="https://api.github.com";
	
	HashMap<Object, Object> map=new HashMap();
	
	map.put("name","Gayu");
	map.put("description", "offonline batch");
	given()
	.auth().oauth2("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")
	.body(map)
	.when()
	.post("/user/repos")
	.then().log().all();
	
}
}
