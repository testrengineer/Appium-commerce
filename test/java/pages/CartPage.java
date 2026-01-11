package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By noItemText = By.id("com.saucelabs.mydemoapp.android:id/noItemTitleTV");
    private By myCartText = By.xpath("//android.widget.TextView[contains(@text,'My Cart')]");
    private By removeButton = By.id("com.saucelabs.mydemoapp.android:id/removeBt");
    private By productTitleText = By.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private By addQuantityButton = By.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private By totalQuantityText = By.id("com.saucelabs.mydemoapp.android:id/itemsTV");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isNoItemTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noItemText));
        return driver.findElement(noItemText).isDisplayed();
    }

    public void waitForMyCartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myCartText));
    }

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }

    private boolean findtemInCart(String productName) {
        List<WebElement> titles = driver.findElements(productTitleText);
        System.out.println(titles);
        boolean productFound = false;
        for (WebElement title : titles) {
            String text = title.getText();
            if(text.equals(productName)) {
                productFound = true;
                break;
            }
        }
        return productFound;
    }

    public void checkItemInCart(String productName) {
        boolean productFound = findtemInCart(productName);
        Assert.assertTrue(productFound, productName + " product not found");
    }

    public void checkItemNotInCart(String productName) {
        boolean productFound = findtemInCart(productName);
        Assert.assertFalse(productFound, productName + " product not found");
    }

    public void clickAddQuantityButton() {
        driver.findElement(addQuantityButton).click();
    }

    private String getQuantity() {
        String quantity = driver.findElement(totalQuantityText).getText();
        return quantity;
    }

    public void checkQuantityAdded() {
        Assert.assertEquals("2 Items", getQuantity());
    }


}
