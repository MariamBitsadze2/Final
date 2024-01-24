package PageObject;

import org.openqa.selenium.By;

public class RegistrationObject {
    protected By
            nameField = By.name("name"),
            surNameField = By.name("surname"),
            personalNumberField = By.name("personal_number"),
            phoneField = By.name("phone"),
            addButton = By.xpath("//*[@id=\"form\"]/div/div[5]/div/button/span");
}
