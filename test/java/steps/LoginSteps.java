package steps;

import base.BaseTest;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("user in homepage")
    public void userInHomepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user navigate to login page")
    public void userNavigateToLoginPage() {
        homePage.clickMenu();
        homePage.clickLoginMenu();
    }

    @And("user log in with valid username and password")
    public void userLogInWithValidUsernameAndPassword() {
        loginPage.waitForLoginText();
        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("10203040");
        loginPage.clickLoginButton();
    }

    @Then("user successfully login")
    public void userSuccessfullyLogin() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickMenu();
        Assert.assertTrue(homePage.isLogOutButtonDisplayed());
    }

    @And("user log in with locked out username and password")
    public void userLogInWithLockedOutUsernameAndPassword() {
        loginPage.waitForLoginText();
        loginPage.inputUsername("alice@example.com (locked out)");
        loginPage.inputPassword("10203040");
        loginPage.clickLoginButton();
    }

    @Then("user failed to login with locked out error")
    public void userFailedToLoginWithLockedOutError() {
        Assert.assertTrue(loginPage.isLockedOutErrorDisplayed());
    }

    @And("user log in with empty username")
    public void userLogInWithEmptyUsername() {
        loginPage.waitForLoginText();
        loginPage.inputUsername("");
        loginPage.clickLoginButton();
    }

    @Then("user failed to login with error username {string}")
    public void userFailedToLoginWithErrorUsername(String message) {
        loginPage.checkUsernameErrorMessage(message);
    }

    @And("user log in with empty password")
    public void userLogInWithEmptyPassword() {
        loginPage.waitForLoginText();
        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("");
        loginPage.clickLoginButton();
    }

    @Then("user failed to login with error password {string}")
    public void userFailedToLoginWithErrorPassword(String message) {
        loginPage.checkPasswordErrorMessage(message);
    }
}
