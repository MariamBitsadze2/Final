package StepObject;

import PageObject.RegistrationObject;
import org.openqa.selenium.WebDriver;

import static DataObject.RegistrationData.*;

public class RegistrationSteps extends RegistrationObject {
    WebDriver driver;
    public RegistrationSteps(WebDriver driver1){
        driver = driver1;
    }
    public void nameFieldAction(String firstName){
        driver.findElement(nameField).sendKeys(firstName);
    }
    public void lastNameFieldAction(String lastName){
        driver.findElement(surNameField).sendKeys(surName);
    }
    public void personalNumberFieldAction(String personalNumber){driver.findElement(personalNumberField).sendKeys(personalNumber); }
    public void phoneFieldAction(String phoneNumber){driver.findElement(phoneField).sendKeys(phoneNumber); }
    public void addButtonAction(){driver.findElement(addButton).click();}
}
