package com.obsqura.rmat_utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Book;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import com.github.javafaker.Food;
import com.github.javafaker.Name;
import com.github.javafaker.Number;
import com.github.javafaker.Options;
import com.github.javafaker.PhoneNumber;
import com.github.javafaker.service.RandomService;

public class FakerUtility
{
	public String getFakeFirstName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.firstName();

		return text;

	}
public String getPassword() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.lastName();

		return text;
	}

	public String getFakeCityName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.cityName();

		return text;

	}
	public String getPhoneNumber()
	{
		Faker faker = new Faker();
		String phoneNumber = faker.phoneNumber().phoneNumber();
		return phoneNumber;
		
	}
	public String getFakeObjectName() {
		Faker faker = new Faker();
		Name name = faker.name();
		String text = name.name();
		//String name = faker.name().name();
		return text;
	}
	public String getFakeCategoryName() {
		Faker faker = new Faker();
		Commerce commerce = faker.commerce();
		String text = commerce.material();
		return text;
	}
	

}
