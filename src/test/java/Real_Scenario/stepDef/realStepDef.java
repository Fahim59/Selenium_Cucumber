package Real_Scenario.stepDef;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class realStepDef {
    public static WebDriver driver;

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        System.out.println("I am on Store Page");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store");
    }

    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String product) throws InterruptedException {
        System.out.println("I add Product in the cart");

        By addTocartBtn = By.xpath("//a[@aria-label='Add “"+product+"” to your cart']");
        driver.findElement(addTocartBtn).click();

        Thread.sleep(1500);

        By viewCartLink = By.xpath("//a[@title='View cart']");
        driver.findElement(viewCartLink).click();
    }

    @Then("I see {int} {string} in the cart")
    public void i_see_in_the_cart(int quantity, String product) {
        System.out.println("I see Product Quantity");

        By proName = By.xpath("//a[normalize-space()='Blue Shoes']");
        String productName = driver.findElement(proName).getText();

        Assert.assertEquals(product, productName);

        By proQuantity = By.xpath("//input[@title='Qty']");
        String productQuantity = driver.findElement(proQuantity).getAttribute("value");

        Assert.assertEquals(quantity, Integer.parseInt(productQuantity));
    }

    @Given("I'm a customer")
    public void iMACustomer() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store");
    }

    @And("I have {int} {string} in the cart")
    public void iHaveQuantityInTheCart(int quantity, String product) throws InterruptedException {
        By addTocartBtn = By.xpath("//a[@aria-label='Add “"+product+"” to your cart']");
        driver.findElement(addTocartBtn).click();

        Thread.sleep(1500);

        By viewCartLink = By.xpath("//a[@title='View cart']");
        driver.findElement(viewCartLink).click();
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() throws InterruptedException {
        By checkoutButton = By.xpath("//a[@class='checkout-button button alt wc-forward']");
        driver.findElement(checkoutButton).click();

        Thread.sleep(1500);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> details) throws InterruptedException {
        //System.out.println("First Name: " +details.get(0).get("first_name"));

        By firstName = By.xpath("//input[@id='billing_first_name']");
        driver.findElement(firstName).sendKeys(details.get(0).get("first_name"));

        By lastName = By.xpath("//input[@id='billing_last_name']");
        driver.findElement(lastName).sendKeys(details.get(0).get("last_name"));

        By country = By.xpath("//span[@id='select2-billing_country-container']");
        driver.findElement(country).click();
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys(details.get(0).get("country"), Keys.ENTER);

        By street = By.xpath("//input[@id='billing_address_1']");
        driver.findElement(street).sendKeys(details.get(0).get("street"));

        By town = By.xpath("//input[@id='billing_city']");
        driver.findElement(town).sendKeys(details.get(0).get("town"));

        By district = By.xpath("//span[@id='select2-billing_state-container']");
        driver.findElement(district).click();
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys(details.get(0).get("state"), Keys.ENTER);

        By postCode = By.xpath("//input[@id='billing_postcode']");
        driver.findElement(postCode).sendKeys(details.get(0).get("zip"));

        By phone = By.xpath("//input[@id='billing_phone']");
        driver.findElement(phone).sendKeys(details.get(0).get("phone"));

        By email = By.xpath("//input[@id='billing_email']");
        driver.findElement(email).sendKeys(details.get(0).get("email"));

        Thread.sleep(1500);
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        By placeOrder = By.xpath("//button[@id='place_order']");
        driver.findElement(placeOrder).click();

        Thread.sleep(1500);
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        By text = By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
        String message = driver.findElement(text).getText();

        Assert.assertEquals("Thank you. Your order has been received.", message);
    }
}