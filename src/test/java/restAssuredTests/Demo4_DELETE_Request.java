package restAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Demo4_DELETE_Request {
	
	@Test
	public void deleteEmployeeRecord() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/11493";
		
		// verify body 
		Response response = 
		// keep given session if there was nothing get specified
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		// convert json to string
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("Error! Not able to delete record"), true);
		
	}
}
