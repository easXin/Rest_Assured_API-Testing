package restAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	String FirstName, LastName,UserName,Password,Email,empName,empSal;

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John")+generatedString;
	}

	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}

	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Kenedy"+generatedString);
	}

	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John"+generatedString);
	}

	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return (generatedString+"gmail.com");
	}

	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John")+generatedString;
	}

	public static String empSal() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public static String empAge() {
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return (generatedString);
	}
	
}
