package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.UserAddress;

public class FakerUtility {
	private static Faker faker = new Faker(new Locale("US"));

	// public static void main(String[] args) {

	private FakerUtility() {
	};

	public static UserAddress getFakeAddress() {

		String address = faker.address().fullAddress();
		System.out.println(address);
		String city = faker.address().city();
		String postCode = faker.numerify("#####");
		String homeMobileNumber = faker.phoneNumber().cellPhone();
		String mobilePhoneNumber = faker.phoneNumber().cellPhone();
		String addressTitle = faker.address().streetAddress();
		String additionalAddress = faker.lorem().paragraph();

		UserAddress userAddress = new UserAddress(address, city, postCode, homeMobileNumber, mobilePhoneNumber,
				addressTitle, additionalAddress);

		return userAddress;
	}

}
