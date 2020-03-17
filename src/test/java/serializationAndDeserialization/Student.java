package serializationAndDeserialization;

import java.util.List;

public class Student {
	public Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String programmer;
	List<String>courses;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgrammer() {
		return programmer;
	}
	public void setProgrammer(String programmer) {
		this.programmer = programmer;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public String getStudentRecord() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", programmer=" + programmer + ", courses=" + courses + "]";
	}
	
	
}
