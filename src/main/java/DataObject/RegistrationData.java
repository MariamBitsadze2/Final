package DataObject;

import com.github.javafaker.Faker;

public class RegistrationData {
    static Faker faker = new Faker();
    public static String
    firstName = faker.name().firstName(),
    surName = faker.name().lastName(),
    personalNumber = faker.bothify("###########"),
    phoneNumber = faker.bothify("5########"),
    tenDigitPersonalNumber  = faker.bothify("##########"),
    eightDigitPhoneNumber = faker.bothify("########"),
    invalidEmail = faker.bothify("??????##");



}
