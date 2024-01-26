package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//a[@data-label='Rejestracja']")
    private WebElement registerButton;


    public MainPage acceptCookies() {
        acceptCookiesButton.click();
        return this;
    }

    public RegisterPage goToRegisterPage() {
        registerButton.click();
        return new RegisterPage(driver);
    }

}
