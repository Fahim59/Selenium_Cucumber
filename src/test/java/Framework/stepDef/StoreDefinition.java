package Framework.stepDef;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.PageFactoryManager;
import pages.StorePage;

public class StoreDefinition {
    public WebDriver driver;
    private final StorePage storePage;

    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public StoreDefinition(TestContext context) {
        driver = context.driver;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Men Page")
    public void i_m_on_the_men_page() throws InterruptedException {
        storePage.clickMenLink();

        BasePage.Scroll_Down();

        logger.info("I'm on the Men Page");
    }

    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String name) {
        storePage.addToCart(name);

        logger.info("I add a " +name+ " to the cart");
    }
}
