package Pages;

import Data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    private WebDriver driver;

    public SettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(linkText = "API")
    private WebElement apiButton;

    @FindBy(xpath = "//input[@class='x-label-field']")
    private WebElement keyLabelInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='summary-info green-box']//dl[2]/dd")
    private WebElement apiKey;

    public SettingsPage goToApiSettings() {
        apiButton.click();
        return this;
    }

    public SettingsPage inputKeyLabel(String keyLabel) {
        keyLabelInput.sendKeys(keyLabel);
        return this;
    }

    public SettingsPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public SettingsPage submit() {
        submitButton.click();
        return this;
    }

    public void getApiKey(User user) {
        user.setApiKey(apiKey.getText());
    }


}
