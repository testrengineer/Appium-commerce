package steps;

import base.BaseTest;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class ProductSteps extends BaseTest {

    HomePage homePage;

    public ProductSteps() {
        homePage = new HomePage(driver);
    }
    @When("I sort the product list by name in (.+) order$")
    public void iSortTheProductListByNameInOrder(String order) {
        if(order.equalsIgnoreCase("ascending")) {
            homePage.sortByNameAscending();
        } else if(order.equalsIgnoreCase("descending")) {
            homePage.sortByNameDescending();
        } else {
            throw new IllegalArgumentException("Invalid sort order: " + order);
        }
    }

    @Then("the products should be displayed (.+) by name$")
    public void theProductsShouldBeDisplayedOrderDescendingByName(String order) {
        homePage.checkProductNameSorting(order);
    }

    @When("I sort the product list by price in (.+) order$")
    public void iSortTheProductListByPriceInOrder(String order) {
        if(order.equalsIgnoreCase("ascending")) {
            homePage.sortByPriceAscending();
        } else if(order.equalsIgnoreCase("descending")) {
            homePage.sortByPriceDescending();
        } else {
            throw new IllegalArgumentException("Invalid sort order: " + order);
        }
    }

    @Then("the products should be displayed (.+) by price$")
    public void theProductsShouldBeDisplayedOrderDescendingByPrice(String order) {
        homePage.checkProductPriceSorting(order);
    }
}
