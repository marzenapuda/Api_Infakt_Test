package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedUserPage {

    private WebDriver driver;


    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//button[@id='onetrust-reject-all-handler' and not (div[@id='onetrust-pc-dark-filter ot-fade-in'])]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//a[@data-tooltip='Ustawienia' and not (div[@id='onetrust-pc-dark-filter ot-fade-in'])]")
    private WebElement settingsButton;

    @FindBy(xpath = "div[@id='onetrust-pc-dark-filter ot-fade-in']")
    private WebElement overlayer;

    public LoggedUserPage acceptCookies() {

        if (driver.getCurrentUrl().equals("https://front.sandbox-infakt.pl/dodaj-fakture")) {
            driver.navigate().to("https://front.sandbox-infakt.pl/start");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs("inFakt"));
        acceptCookiesButton.click();
        return this;
    }

    public SettingsPage goToSettings() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(overlayer));
        settingsButton.click();
        return new SettingsPage(driver);
    }


}
