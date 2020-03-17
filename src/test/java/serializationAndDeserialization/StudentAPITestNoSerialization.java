package serializationAndDeserialization;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPITestNoSerialization {
	public HashMap map = new HashMap();
	
	
	/* Post & Get request w/o serialization & de-serialization*/
	// Post requests creates a new student record
	@Test(priority = 1)
	public void createNewStudent() {
		map.put("id", 101);
		map.put("firstName", "Pavan");
		map.put("lastName", "Kumar");
		map.put("email", "acbxyz@gmail.com");
		map.put("programmer", "Manger");
		// store multiple element in a single value
		ArrayList<String>courseList = new ArrayList<>();
		courseList.add("Java");
		courseList.add("Selenium");
		map.put("courses",courseList);
		
		// send post request
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		// send request
		.when()
			.post("http://localhost:8805/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg", equalTo("Student added"));
	}
	
	// Get request to retrieve student details
	@Test(priority = 2)
	public void getStudentRecord() {
		given()
		.when()
			.get("http://localhost:8085/student/101")
		.then()
			.statusCode(200)
			.assertThat()
			.body("id",equalTo(101))
			.log().all();
	}
	
	/* Post & Get request with serialization & de-serialization*/
}
