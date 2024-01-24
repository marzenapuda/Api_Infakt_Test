package Tests;

import Config.DriverFactory;
import Data.User;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
     protected WebDriver driver;

    @BeforeSuite
    public void setup(){
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
        System.out.println(user.getApiKey());


    }


}
