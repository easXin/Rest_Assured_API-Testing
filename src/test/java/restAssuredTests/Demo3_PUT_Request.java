package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo3_PUT_Request {
	
	public static HashMap map = new HashMap();
	
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	/* modify this employee's data via this emp_id*/
	int emp_id=11254;
	
	@BeforeClass
	public void putData() {
		map.put("name", empName);
		map.put("salary", empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		// update record
		RestAssured.basePath="/update/"+emp_id;
	}
	@Test
	public void testPUT() {
		given()
			// must specify when request is type of post or put
			.contentType("application/json")
			// passing data
			.body(map)
		.when()
		    // what kind of request
			.put()
		.then()
			.statusCode(200);
	}
}
