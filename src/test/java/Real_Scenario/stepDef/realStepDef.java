package Real_Scenario.stepDef;

import Real_Scenario.constants.EndPoint;
import Real_Scenario.context.TestContext;
import Real_Scenario.factory.DriverFactory;
import Real_Scenario.pages.CartPage;
import Real_Scenario.pages.CheckoutPage;
import Real_Scenario.pages.StorePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class realStepDef {
    public WebDriver driver;

    public realStepDef(TestContext context) {
        driver = context.driver;
    }

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        new StorePage(driver).OpenWebsite(EndPoint.STORE.url);
    }

    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String name) {
        new StorePage(driver).addToCart(name);
    }

    @Then("I see {int} {string} in the cart")
    public void i_see_in_the_cart(int quantity, String name) {
        Assert.assertEquals(name, new CartPage(driver).getProductName());

        Assert.assertEquals(quantity, new CartPage(driver).getProductQuantity());
    }
    //-----------------------------------------------------------------------------------------------//

    @Given("I'm a customer")
    public void iMACustomer() {
        new StorePage(driver).OpenWebsite(EndPoint.STORE.url);
    }

    @And("I have {int} {string} in the cart")
    public void iHaveQuantityInTheCart(int quantity, String name) {
        new StorePage(driver).addToCart(name);
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        new CartPage(driver).checkout();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> details) {

        new CheckoutPage(driver).setBillingDetails(details.get(0).get("first_name"),
                details.get(0).get("last_name"),
                details.get(0).get("country"),
                details.get(0).get("street"),
                details.get(0).get("town"),
                details.get(0).get("state"),
                details.get(0).get("zip"),
                details.get(0).get("phone"),
                details.get(0).get("email")
        );
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(driver).placeorder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).text());
    }
}