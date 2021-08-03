package com.comcast.ComplexData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.comcast.POJOClass.ProjectLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class MultipleProj_UsingDataProvider {
	
	@Test (dataProvider="getData")
	public void createMultipleProject(String createdBy, String projectName,  int teamSize) {
	baseURI="http://localhost";
	port=8084;
			
		
		ProjectLibrary proj=new ProjectLibrary(createdBy, projectName, "completed", teamSize);
	given()
	.contentType(ContentType.JSON)
	.body(proj)
	.when()
	.post("/addProject")
	.then()
	.log().all();
		
	}

	@DataProvider
	public Object[][] getData()
	{
	Object[][] obj=new Object[3][3];
	obj[0][0]="yandra";
	obj[0][1]="rmg";
	obj[0][2]=15;
	
	obj[1][0]="meenu";
	obj[1][1]="viji";
	obj[1][2]=25;
	
	obj[2][0]="Keni";
	obj[2][1]="bini";
	obj[2][2]=65;
	
	
	
	return obj;
	}
	
	


	
	
	}
