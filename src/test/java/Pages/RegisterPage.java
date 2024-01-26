package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[@for='user_terms_of_service']")
    private WebElement checkbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;


    public RegisterPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegisterPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterPage clickCheckbox() {
        checkbox.click();
        return this;
    }

    public LoggedUserPage clickRegister() {
        registerButton.click();
        return new LoggedUserPage(driver);
    }
}
