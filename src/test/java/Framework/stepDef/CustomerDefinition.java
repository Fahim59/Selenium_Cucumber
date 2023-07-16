package Framework.stepDef;

import context.TestContext;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CustomerDefinition {
    public WebDriver driver;

    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CustomerDefinition(TestContext context) {
        driver = context.driver;
    }

    @Given("I'm a customer")
    public void iMACustomer() {
        BasePage.Open_Website("");

        logger.info("I'm a customer");
    }
}
