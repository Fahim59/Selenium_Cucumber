package Framework.stepDef;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CartPage;
import pages.PageFactoryManager;
import pages.StorePage;

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

    @Then("I see {int} {string} in the cart")
    public void i_see_in_the_cart(int quantity, String name) {
        Assert.assertEquals(name, cartPage.getProductName());

        Assert.assertEquals(quantity, cartPage.getProductQuantity());

        logger.info("I see " +quantity+ " "+name+ " in the cart");
    }

    @Then("I apply {string}")
    public void iApply(String coupon) throws InterruptedException {
        BasePage.SmallWait(2000);

        cartPage.enterCoupon(coupon);
        cartPage.clickApplyCoupon();

        logger.info("I apply coupon code " +coupon);
    }

    @Then("Coupon should be applied")
    public void couponShouldBeApplied() {
        Assert.assertEquals("Coupon code applied successfully.", cartPage.text());

        logger.info("Coupon applied");
    }
}
