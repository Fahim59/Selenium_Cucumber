package Framework.stepDef;

import context.TestContext;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.PageFactoryManager;

import java.util.List;
import java.util.Map;

public class CheckoutDefinition {
    public WebDriver driver;
    private final CheckoutPage checkoutPage;
    private final CartPage cartPage;

    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CheckoutDefinition(TestContext context) {
        driver = context.driver;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() throws InterruptedException {
        BasePage.SmallWait(1500);

        cartPage.checkout();

        logger.info("I'm on the checkout page");
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> details) {

        checkoutPage.setBillingDetails(details.get(0).get("first_name"),
                details.get(0).get("last_name"),
                details.get(0).get("country"),
                details.get(0).get("street"),
                details.get(0).get("town"),
                details.get(0).get("state"),
                details.get(0).get("zip"),
                details.get(0).get("phone"),
                details.get(0).get("email")
        );

        logger.info("I provide billing details");
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        BasePage.SmallWait(1500);

        checkoutPage.placeorder();

        logger.info("I place an order");
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {
        BasePage.SmallWait(1500);

        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.text());

        logger.info("The order should be placed successfully");
    }
}
