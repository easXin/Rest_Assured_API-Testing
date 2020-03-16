package restAssuredTests;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
 	Test status code
 	Log response
 	Verifying single content in response body
 	Verifying multiple contents in response body
 	Setting parameter & header
 */
public class Demo5_BasicValidation_JSON {
	
	// Test status code
	@Test(priority = 1)
	public void testStatusCode() {
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			// return header and response body
			.log().all();
	}
	
	// Log response
	@Test(priority = 2)
	public void testLogging() {
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	// Verifying single content in response body
	@Test(priority = 3)
	public void testSingleContent() {
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			// JSON path
			.body("RestResponse.result.name", equalTo("India"));
	}
	
	// Verifying multiple contents in response body
	@Test(priority = 4)
	public void testMutipleContent() {
		given()
		.when()
			.get("http://services.groupkt.com/country/get/all")
		.then()
			.statusCode(200)
			// JSON path
			.body("RestResponse.result.name", hasItems("India","Australia","United States of America"));
	}
	
	// Log response
	@Test(priority = 5)
	public void testParametersAndHeader() {
		given()
			.param("MyName", "pavan")
			.header("MyHeader","Indian")
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.log().all();
	}
	
}
