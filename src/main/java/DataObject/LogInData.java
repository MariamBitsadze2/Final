package DataObject;

import com.github.javafaker.Faker;

public class LogInData {
static Faker faker = new Faker();
public static String
   correctEmailData = "m_bitsadze2@cu.edu.ge",
   correctPasswordData = "Test1234",
   incorrectEmailData = faker.bothify("????##@gmail.com"),
   incorrectPasswordData = faker.bothify("####????##??"),
   passwordWith7Characters = faker.bothify("####???");

}