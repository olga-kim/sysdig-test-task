package steps.implementation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Login {

    private WebDriver driver;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("Navigate to Login Page")
    public void navigateToLoginPage() {
        loginPage.open();
    }

    @When("User enters a valid email and valid password")
    public void userEntersValidEmailAndPassword() {
        loginPage.enterUsername("TBD");
        loginPage.enterPassword("TBD");
    }

    @And("User clicks on Log in button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("User enters invalid credentials")
    public void userEntersInvalidEmailAndPassword() {
        loginPage.enterUsername("test@mail.com");
        loginPage.enterPassword("pass");
    }

    @When("User clicks on Forgot password link")
    public void userClicksOnForgotPasswordLink() {
        loginPage.clickForgotPasswordLink();
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        assertThat(loginPage.getErrorMessage(), equalTo("Credentials are not valid"));
    }

    @Then("Forgot password page is opened")
    public void forgotPasswordPageIsOpened() {
        assertThat(forgotPasswordPage.isPageOpened(), equalTo(true));
    }

}