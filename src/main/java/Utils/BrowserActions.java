package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserActions {
    public static WebDriver driver;

    @BeforeMethod
    public  void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.starling.ge/ka");
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }
}
