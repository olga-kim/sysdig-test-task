package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPage extends BasePage {

    private String URL = "https://app.sysdigcloud.com/#/forgotPassword";

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(css = "button[data-test='submit-forgot-password'][type='submit']")
    private WebElement passwordResetButton;

    @FindBy(xpath = "//a[contains(text(), 'login')]")
    private WebElement backToLoginLink;

    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.urlToBe(URL));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
