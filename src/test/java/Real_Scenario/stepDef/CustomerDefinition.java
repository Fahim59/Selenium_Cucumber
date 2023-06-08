package Real_Scenario.stepDef;

import Real_Scenario.constants.*;
import Real_Scenario.context.TestContext;
import Real_Scenario.pages.PageFactoryManager;
import Real_Scenario.pages.StorePage;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;

public class CustomerDefinition {
    public WebDriver driver;
    private final StorePage storePage;

    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CustomerDefinition(TestContext context) {
        driver = context.driver;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm a customer")
    public void iMACustomer() {
        storePage.OpenWebsite(EndPoint.STORE.url);

        logger.info("I'm a customer");
    }
}
