package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static final String URL = "https://app.sysdigcloud.com/";

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[data-id='submit-login'][type='submit']")
    private WebElement loginButton;

    @FindBy(css = "a[data-test='link-forgot-password']")
    private WebElement forgotPasswordLink;

    @FindBy(css = "p[data-test='login-error-message']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
        waitUntilElementToBeClickable(loginButton);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public String getErrorMessage() {
        waitUntilElementToBeClickable(errorMessage);
        return errorMessage.getText();
    }
}
