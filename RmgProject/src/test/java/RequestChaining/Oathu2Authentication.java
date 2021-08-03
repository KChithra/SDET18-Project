package RequestChaining;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Oathu2Authentication {
	@Test
	public void Oauth2Program() {
	
	//provide the client ID and client secret to generate the token 
		Response resp=given()
	.formParam("client_id", "SDET18_CK")
	.formParam("client_secret", "0418777b39a6c3893f365355f47f329a")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://example.com")
	.formParam("code", "client_credentials")
	
	//generate the token
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	System.out.println(resp.asPrettyString());
	String MyToken=resp.jsonPath().get("access_token");
	System.out.println(MyToken);
	
	//use this token in any API
	given()
	.auth()
	.oauth2(MyToken)
	.pathParam("USER_ID", "2113")
	.when()
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	
	.then().log().all();
	
	}
}
