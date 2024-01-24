import StepObject.LoginSteps;
import StepObject.RegistrationSteps;
import Utils.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static DataObject.LogInData.*;
import static DataObject.RegistrationData.*;

public class LogIn extends BrowserActions {
    @Test(priority = 1)
    public void LogInWithCorrectData() {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(correctPasswordData);
        step.loInButtonAction();

        String
                expectedResult = "ოთახის ნომერი: ST4885",
                actualResult = driver.findElement(By.tagName("h5")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();
    }


    @Test (priority = 2)
    public void LogInWithIncorrectData() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(incorrectEmailData);
        step.passwordFieldAction(incorrectPasswordData);
        step.loInButtonAction();

        String
                expectedResult = "ეს მონაცემები არ შეესაბამება ჩვენს ჩანაწერებს",
                actualResult = driver.findElement(By.tagName("strong")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void LogInWithoutPassword() {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.loInButtonAction();

        String
                expectedResult = "This Field Is Required.",
                actualResult = driver.findElement(By.id("password-error")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();
    }

    @Test (priority = 4)
    public void LogInWithInvalidPasswordFormat() {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(passwordWith7Characters);
        step.loInButtonAction();

        String
                expectedResult = "Please Enter At Least 8 Characters.",
                actualResult = driver.findElement(By.id("password-error")).getText();

        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertEquals(actualResult, expectedResult);

        softAssert1.assertAll();
    }


    @Test (priority = 5)
    public void RegistrationOfTrustee() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(correctPasswordData);
        step.loInButtonAction();

        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/div/div[1]/button/i"));
        //WebElement xButton = driver.findElement(By.xpath("//button [@type = 'button' and @class = 'rbt-round-btn']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        xButton.click();

        WebElement myTrustee = driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div[2]/div[2]/ul/li/div/div/ul[1]/li[3]/a/span"));


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(myTrustee));
        myTrustee.click();

        RegistrationSteps step1 = new RegistrationSteps(driver);
        step1.nameFieldAction(firstName);
        step1.lastNameFieldAction(surName);
        step1.personalNumberFieldAction(personalNumber);
        step1.phoneFieldAction(phoneNumber);
        step1.addButtonAction();
        Thread.sleep(5000);

        String
                expectedResult = "წაშლა",
                actualResult = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]/form/button")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();

    }

    @Test (priority = 6)
    public void RegistrationOfTrusteeWithoutFirstname() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(correctPasswordData);
        step.loInButtonAction();

        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/div/div[1]/button/i"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        xButton.click();

        WebElement myTrustee = driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div[2]/div[2]/ul/li/div/div/ul[1]/li[3]/a/span"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(myTrustee));
        myTrustee.click();

        RegistrationSteps step1 = new RegistrationSteps(driver);
        step1.lastNameFieldAction(surName);
        step1.personalNumberFieldAction(personalNumber);
        step1.phoneFieldAction(phoneNumber);
        step1.addButtonAction();
        Thread.sleep(5000);

        String
                expectedResult = "rgba(255, 0, 0, 1)",
                actualResult = driver.findElement(By.id("name-error")).getCssValue("color");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();
    }

    @Test (priority = 7)
    public void RegistrationOfTrusteeWithTenDigitPersonalNumber() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(correctPasswordData);
        step.loInButtonAction();

        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/div/div[1]/button/i"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        xButton.click();

        WebElement myTrustee = driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div[2]/div[2]/ul/li/div/div/ul[1]/li[3]/a/span"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(myTrustee));
        myTrustee.click();

        RegistrationSteps step1 = new RegistrationSteps(driver);
        step1.nameFieldAction(firstName);
        step1.lastNameFieldAction(surName);
        step1.personalNumberFieldAction(tenDigitPersonalNumber);
        step1.phoneFieldAction(phoneNumber);
        step1.addButtonAction();
        Thread.sleep(5000);

        String
                expectedResult = "Please Enter At Least 11 Characters.",
                actualResult = driver.findElement(By.id("personal_number-error")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();

    }

    @Test (priority = 8)
    public void RegistrationOfTrusteeWithEightDigitPhoneNumber() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(correctPasswordData);
        step.loInButtonAction();

        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/div/div[1]/button/i"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        xButton.click();

        WebElement myTrustee = driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div[2]/div[2]/ul/li/div/div/ul[1]/li[3]/a/span"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(myTrustee));
        myTrustee.click();

        RegistrationSteps step1 = new RegistrationSteps(driver);
        step1.nameFieldAction(firstName);
        step1.lastNameFieldAction(surName);
        step1.personalNumberFieldAction(personalNumber);
        step1.phoneFieldAction(eightDigitPhoneNumber);
        step1.addButtonAction();
        Thread.sleep(5000);

        String
                expectedResult = "Please Enter At Least 9 Characters.",
                actualResult = driver.findElement(By.id("phone-error")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();

    }

    @Test (priority = 9)
    public void OfficeAddressChange() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(correctPasswordData);
        step.loInButtonAction();

        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/div/div[1]/button/i"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        xButton.click();

        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div/div/nav/ul/li[9]/a/span"));
        profile.click();

        By addressDropDown = By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/div/div/form/div[10]/div/div/div/div/button/div/div/div");
        driver.findElement(addressDropDown).click();

        WebElement address = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/div/div/form/div[10]/div/div/div/div/div/div/ul/li[2]/a/span"));
        address.click();

        WebElement saveButton = driver.findElement(By.xpath("//button [@class = 'rbt-btn btn-bg-img rbt-switch-btn rbt-switch-y w-100']"));
        saveButton.click();


        String
                expectedResult = "წარმატებით განახლდა ინფორმაცია",
                actualResult = driver.findElement(By.xpath("/html/body/div[1]")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();

        /*
        By addressDropDown = By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/div/div/form/div[10]/div/div/div/div/button/div/div/div");
        driver.findElement(addressDropDown).click();

        Select selectAddress = new Select(driver.findElement(addressDropDown));

        for( int i = 0; i < 6; i++ ){
            selectAddress.selectByValue("თბილისი: ორთაჭალა: დიმიტრი გულიას 5");
            Thread.sleep(2000); }*/

    }

    @Test (priority = 10)
    public void EmailAddressChange() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmailData);
        step.passwordFieldAction(correctPasswordData);
        step.loInButtonAction();

        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/div/div[1]/button/i"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        xButton.click();

        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div/div/nav/ul/li[9]/a/span"));
        profile.click();

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys(invalidEmail);

        WebElement saveButton = driver.findElement(By.xpath("//button [@class = 'rbt-btn btn-bg-img rbt-switch-btn rbt-switch-y w-100']"));
        saveButton.click();

        Thread.sleep(5000);

        String
                expectedResult = "Please Enter A Valid Email Address.",
                actualResult = driver.findElement(By.xpath("//label [@id='email-error']")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();



    }
}








