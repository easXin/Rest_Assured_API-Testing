package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 Given()
	Set cookies,Add auth, Add param, Set header info etc ..
 When()
	Get, Post, Put, Delete …
 Then()
    Validate status code, Extract response, Extract header, Cookies, Response body
 Validation
 	Status code, status line, response body, header
 */

public class Demo1_GET_Request {
	
	@Test
	public void getWeatherDetails()
	{
		given()
		.when()
			.get("https://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("City", equalTo("Hyderabad"))
			.header("Content-Type","application/json");
		   
	}
}
