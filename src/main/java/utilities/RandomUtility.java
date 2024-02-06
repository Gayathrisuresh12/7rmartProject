package utilities;

import com.github.javafaker.Faker;

public class RandomUtility {

	public static String getRandomName() {
		Faker faker = new Faker();
		return faker.name().name();
	}

	public static String getRandomFullName() {
		Faker faker = new Faker();
		return faker.name().fullName();
	}

	public static String getRandomUserName() {
		Faker faker = new Faker();
		return faker.name().username();
	}

	public static String getRandomFirstName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public static String getRandomMiddleName() {
		Faker faker = new Faker();
		return faker.name().nameWithMiddle();
	}

	public static String getRandomLastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}

	public static String getRandomPhoneNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().phoneNumber();
	}

	public static String getRandomAddress() {
		Faker faker = new Faker();
		return faker.address().fullAddress();
	}

	public static String getRandomOfferCode() {
		Faker faker = new Faker();
		String couponCode = faker.bothify("?###???"); 
		couponCode = couponCode.toUpperCase();
		return couponCode;
	}	
}
