package restAssuredTests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Demo6_BasicValidation_XML {

	// verify single content in XML response
	@Test(priority = 1)
	public void testSingleContent() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();
	}
	
	// verify multiple contents in XML response
	@Test(priority = 2)
	public void testMutipleContent() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY", equalTo("Seattle"));
	}
	
	// verify all the content in XML response in one go
	@Test(priority = 3)
	public void testMutipleContentInOneGo() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	
	//Find values using XML path in XML response
	@Test(priority = 4)
	public void testUsingXpath1() {
		given()
		.when()
			// send request
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			// XML PATH
			.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Bill"));
	}
	
	@Test(priority = 5)
	public void testUsingXpath2() {
		given()
		.when()
			// send request
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			// XML PATH + root tag
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
	}
}
