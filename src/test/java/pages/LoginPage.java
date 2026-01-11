package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By usernameInput = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By passwordInput = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private By loginButton = By.id("com.saucelabs.mydemoapp.android:id/loginBtn");
    private By loginHeader = By.id("com.saucelabs.mydemoapp.android:id/loginTV");
    private By lockedOutErrorMessage = By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/passwordErrorTV']");
    private By usernameErrorMessage = By.id("com.saucelabs.mydemoapp.android:id/nameErrorTV");
    private By passwordErrorMessage = By.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV");

    public LoginPage (AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void inputUsername (String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void inputPassword (String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton () {
        driver.findElement(loginButton).click();
    }

    public void waitForLoginText () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
    }

    public boolean isLockedOutErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lockedOutErrorMessage));
        return driver.findElement(lockedOutErrorMessage).isDisplayed();
    }

    public void checkUsernameErrorMessage(String message) {
        Assert.assertEquals(message, driver.findElement(usernameErrorMessage).getText());
    }

    public void checkPasswordErrorMessage(String message) {
        Assert.assertEquals(message, driver.findElement(passwordErrorMessage).getText());
    }
}
