package steps;

import base.BaseTest;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;

public class CheckoutSteps extends BaseTest {
    HomePage homePage;
    CartPage cartPage;

    public CheckoutSteps() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }
    @When("the user opens the cart")
    public void theUserOpensTheCart() {
        homePage.clickCartMenu();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        cartPage.isNoItemTextDisplayed();
    }

    @When("user add item to cart")
    public void userAddItemToCart() {
        homePage.clickProduct("Sauce Labs Backpack");
        homePage.clickAddToCartButton();
    }

    @And("user remove item from cart")
    public void userRemoveItemFromCart() {
        cartPage.waitForMyCartPage();
        cartPage.checkItemInCart("Sauce Labs Backpack");
        cartPage.clickRemoveButton();
    }

    @Then("the item should be removed from cart")
    public void theItemShouldBeRemovedFromCart() {
        cartPage.isNoItemTextDisplayed();
    }

    @Then("the item should be added to cart")
    public void theItemShouldBeAddedToCart() {
        cartPage.waitForMyCartPage();
        cartPage.checkItemInCart("Sauce Labs Backpack");
    }

    @And("user add quantity from cart")
    public void userAddQuantityFromCart() {
        cartPage.waitForMyCartPage();
        cartPage.clickAddQuantityButton();
    }

    @Then("the item quantity should be added")
    public void theItemQuantityShouldBeAdded() {
        cartPage.checkQuantityAdded();
    }
}
