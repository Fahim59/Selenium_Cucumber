package Real_Scenario.stepDef;

import Real_Scenario.constants.EndPoint;
import Real_Scenario.context.TestContext;
import Real_Scenario.pages.CartPage;
import Real_Scenario.pages.CheckoutPage;
import Real_Scenario.pages.PageFactoryManager;
import Real_Scenario.pages.StorePage;
import io.cucumber.java.en.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Map;

public class realStepDef {
    public WebDriver driver;
    private final CartPage cartPage;
    private final StorePage storePage;
    private final CheckoutPage checkoutPage;

    private static final Logger logger = LogManager.getLogger(realStepDef.class);

    public static void main(String[] args) {
        Configurator.initialize(null, "log4j2.xml");
    }

    public static void saveLogFile() {
        try {
            File logFile = new File("Log Result/test.log");
            File outputFile = new File("Log Result/test_output.txt");

            String logContents = FileUtils.readFileToString(logFile, "UTF-8");
            FileUtils.writeStringToFile(outputFile, logContents, "UTF-8");

            logger.info("Log file saved to: " + outputFile.getAbsolutePath());
        }
        catch (Exception e) {
            logger.error("Error saving log file", e);
        }
    }

    public realStepDef(TestContext context) {
        driver = context.driver;
        cartPage = PageFactoryManager.getCartPage(context.driver);
        storePage = PageFactoryManager.getStorePage(context.driver);
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        storePage.OpenWebsite(EndPoint.STORE.url);
    }

    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String name) {
        storePage.addToCart(name);
    }

    @Then("I see {int} {string} in the cart")
    public void i_see_in_the_cart(int quantity, String name) {
        Assert.assertEquals(name, cartPage.getProductName());

        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
    //-----------------------------------------------------------------------------------------------//

    @Given("I'm a customer")
    public void iMACustomer() {
        storePage.OpenWebsite(EndPoint.STORE.url);
    }

    @And("I have {int} {string} in the cart")
    public void iHaveQuantityInTheCart(int quantity, String name) {
        storePage.addToCart(name);
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        cartPage.checkout();
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
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeorder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.text());
    }
}