package Tests;

import Config.DriverFactory;
import Data.User;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://konto.sandbox-infakt.pl/rejestracja");
        User user = new User();

        new RegisterPage(driver)
                .fillEmail(user.getRandomEmail())
                .fillPassword(user.getPassword())
                .clickCheckbox()
                .clickRegister()
                .acceptCookies()
                .goToSettings()
                .goToApiSettings()
                .inputKeyLabel(user.getKeyLabel())
                .inputPassword(user.getPassword())
                .submit().getApiKey(user);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
