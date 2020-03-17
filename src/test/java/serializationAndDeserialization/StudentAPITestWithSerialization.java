package serializationAndDeserialization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
public class StudentAPITestWithSerialization {
	
	@Test(priority=1)
	public void createNewStudentSerialization() {
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student stu = new Student();
		stu.setId(101);
		stu.setFirstName("John");
		stu.setLastName("Deo");
		stu.setEmail("abc@gmail.com");
		stu.setProgrammer("Computer science");
		stu.setCourses(coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post("http://localhost:8805/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg",equalTo("Student added"));
	}
	
	@Test(priority=2)
	public void getStudentRecordDeSerialization() {
		// capture response -> convert into obj -> through obj extracting data -> compare data
		Student stu = 
				// whatever type i am getting, that would be converted into student.class
				get("http://localhost:8805/student/101").as(Student.class);
		// retrieve the data from database
		System.out.println(stu.getStudentRecord());
		Integer i = 101;
		assertEquals(stu.getId(), i);

	}
}
