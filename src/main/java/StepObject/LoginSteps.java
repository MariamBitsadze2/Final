package StepObject;

import PageObject.LogInObject;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends LogInObject {
    WebDriver driver;
    public LoginSteps(WebDriver driver1){
        driver = driver1;
    }
    public void emailFieldAction(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void passwordFieldAction(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void loInButtonAction(){
        driver.findElement(logInButton).click();
    }

}
