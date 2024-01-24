package PageObject;

import org.openqa.selenium.By;

public class LogInObject {
    protected By
            emailField = By.name("email"),
            passwordField = By.xpath("//input [ @type = 'password']"),
            logInButton = By.xpath("//button [ @type = 'submit']");
}
