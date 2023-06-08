package Real_Scenario.stepDef;

import Real_Scenario.constants.EndPoint;
import Real_Scenario.context.TestContext;
import Real_Scenario.pages.CheckoutPage;
import Real_Scenario.pages.PageFactoryManager;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CheckoutDefinition {
    public WebDriver driver;
    private final CheckoutPage checkoutPage;

    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CheckoutDefinition(TestContext context) {
        driver = context.driver;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.OpenWebsite(EndPoint.CHECKOUT.url);

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
    public void iPlaceAnOrder() {
        checkoutPage.placeorder();

        logger.info("I place an order");
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.text());

        logger.info("The order should be placed successfully");
    }
}
