package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By menuButton = By.id("com.saucelabs.mydemoapp.android:id/menuIV");
    private By productHeader = By.id("com.saucelabs.mydemoapp.android:id/productTV");
    private By logInButton = By.xpath("//android.widget.TextView[@content-desc='Login Menu Item']");
    private By logOutButton = By.xpath("//android.widget.TextView[@content-desc='Logout Menu Item']");
    private By sortButton = By.id("com.saucelabs.mydemoapp.android:id/sortIV");
    private By sortPopUp = By.id("com.saucelabs.mydemoapp.android:id/sortTV");
    private By sortNameDescending = By.xpath("//android.widget.TextView[@text='Name - Descending']");
    private By sortNameAscending = By.xpath("//android.widget.TextView[@text='Name - Ascending']");
    private By sortPriceDescending = By.xpath("//android.widget.TextView[@text='Price - Descending']");
    private By sortPriceAscending = By.xpath("//android.widget.TextView[@text='Price - Ascending']");
    private By productPricesText = By.xpath("//android.widget.TextView[@content-desc='Product Price']");
    private By cartButton = By.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private By addToCartButton = By.id("com.saucelabs.mydemoapp.android:id/cartBt");


    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isHomePageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productHeader));
        return driver.findElement(productHeader).isDisplayed();
    }

    public void clickMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickLoginMenu() {
        driver.findElement(logInButton).click();
    }

    public boolean isLogOutButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        return driver.findElement(logOutButton).isDisplayed();
    }

    public void sortByNameAscending() {
        driver.findElement(sortButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortPopUp));
        driver.findElement(sortNameAscending).click();

    }

    public void sortByNameDescending() {
        driver.findElement(sortButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortPopUp));
        driver.findElement(sortNameDescending).click();
    }
    public void sortByPriceAscending() {
        driver.findElement(sortButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortPopUp));
        driver.findElement(sortPriceAscending).click();

    }

    public void sortByPriceDescending() {
        driver.findElement(sortButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortPopUp));
        driver.findElement(sortPriceDescending).click();
    }

    private List<String> getProductNames() {
        List<WebElement> products = driver.findElements(
                By.xpath("//android.widget.TextView[@content-desc='Product Title']")
        );

        List<String> productNames = new ArrayList<>();
        for (WebElement product : products) {
            productNames.add(product.getText());
        }
        return productNames;
    }

    public void checkProductNameSorting(String sort) {
        List<String> names = getProductNames();
        if (names.size() < 2) {
            throw new IllegalStateException("Not enough products name to compare");
        }
        System.out.println(names);
        if(sort.equalsIgnoreCase("ascending")) {
            Assert.assertTrue(
                    names.get(0).compareTo(names.get(1)) <= 0
            );
        } else if (sort.equalsIgnoreCase("descending")) {
            Assert.assertTrue(
                    names.get(0).compareTo(names.get(1)) >= 0
            );
        }

    }
    private List<String> getProductprices() {
        List<WebElement> products = driver.findElements(productPricesText);

        List<String> productPrices = new ArrayList<>();
        for (WebElement product : products) {
            productPrices.add(product.getText());
        }
        return productPrices;
    }

    public void checkProductPriceSorting(String sort) {
        List<String> prices = getProductprices();
        if (prices.size() < 2) {
            throw new IllegalStateException("Not enough products price to compare");
        }
        System.out.println(prices);
        if(sort.equalsIgnoreCase("ascending")) {
            Assert.assertTrue(
                    prices.get(0).compareTo(prices.get(1)) <= 0
            );
        } else if (sort.equalsIgnoreCase("descending")) {
            Assert.assertTrue(
                    prices.get(0).compareTo(prices.get(1)) >= 0
            );
        }

    }

    public void clickCartMenu() {
        driver.findElement(cartButton).click();
    }

    public void clickProduct(String productTitle) {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Product Title' and @text='" + productTitle + "']/parent::android.view.ViewGroup")).click();
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
    }
}
