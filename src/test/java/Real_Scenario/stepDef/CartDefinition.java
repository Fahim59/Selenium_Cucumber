package Real_Scenario.stepDef;

import Real_Scenario.context.TestContext;
import Real_Scenario.pages.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartDefinition {
    public WebDriver driver;
    private final CartPage cartPage;
    private final StorePage storePage;

    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CartDefinition(TestContext context) {
        driver = context.driver;
        storePage = PageFactoryManager.getStorePage(context.driver);
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @And("I have {int} {string} in the cart")
    public void iHaveQuantityInTheCart(int quantity, String name) {
        storePage.addToCart(name);

        logger.info("I have {int} {string} in the cart");
    }

    @Then("I see {int} {string} in the cart")
    public void i_see_in_the_cart(int quantity, String name) {
        Assert.assertEquals(name, cartPage.getProductName());

        Assert.assertEquals(quantity, cartPage.getProductQuantity());

        logger.info("I see {int} {string} in the cart");
    }
}
