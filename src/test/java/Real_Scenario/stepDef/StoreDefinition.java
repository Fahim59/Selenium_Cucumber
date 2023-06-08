package Real_Scenario.stepDef;

import Real_Scenario.constants.EndPoint;
import Real_Scenario.context.TestContext;
import Real_Scenario.pages.PageFactoryManager;
import Real_Scenario.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;

public class StoreDefinition {
    public WebDriver driver;
    private final StorePage storePage;
    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public StoreDefinition(TestContext context) {
        driver = context.driver;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        storePage.OpenWebsite(EndPoint.STORE.url);

        logger.info("I'm on the Store Page");
    }

    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String name) {
        storePage.addToCart(name);

        logger.info("I add a {string} to the cart");
    }
}
