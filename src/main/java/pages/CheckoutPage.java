package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By textField = By.xpath("//input[@role='combobox']");
    private final By firstNameField = By.xpath("//input[@id='billing_first_name']");
    private final By lastNameField = By.xpath("//input[@id='billing_last_name']");
    private final By countryField = By.xpath("//span[@id='select2-billing_country-container']");
    private final By streetField = By.xpath("//input[@id='billing_address_1']");
    private final By townField = By.xpath("//input[@id='billing_city']");
    private final By districtField = By.xpath("//span[@id='select2-billing_state-container']");
    private final By postCodeField = By.xpath("//input[@id='billing_postcode']");
    private final By phoneField = By.xpath("//input[@id='billing_phone']");
    private final By emailField = By.xpath("//input[@id='billing_email']");

    private final By placeOrderButton = By.xpath("//button[@id='place_order']");

    private final By textMessage = By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");

    public CheckoutPage enterFirstName(String firstName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        element.clear();
        element.sendKeys(firstName);

        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        element.clear();
        element.sendKeys(lastName);

        return this;
    }

    public CheckoutPage enterCountry(String country){
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryField)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(textField)).sendKeys(country, Keys.ENTER);

        return this;
    }

    public CheckoutPage enterStreet(String street){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(streetField));
        element.clear();
        element.sendKeys(street);

        return this;
    }

    public CheckoutPage enterTown(String town){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(townField));
        element.clear();
        element.sendKeys(town);

        return this;
    }

    public CheckoutPage enterDistrict(String district){
        wait.until(ExpectedConditions.visibilityOfElementLocated(districtField)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(textField)).sendKeys(district, Keys.ENTER);

        return this;
    }

    public CheckoutPage enterPostCode(String postCode){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(postCodeField));
        element.clear();
        element.sendKeys(postCode);

        return this;
    }

    public CheckoutPage enterPhone(String phone){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        element.clear();
        element.sendKeys(phone);

        return this;
    }

    public CheckoutPage enterEmail(String email){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.clear();
        element.sendKeys(email);

        return this;
    }

    public CheckoutPage setBillingDetails(String firstName, String lastName, String country, String street,
                                          String town, String district, String postCode, String phone, String email){

        return enterFirstName(firstName).enterLastName(lastName).enterCountry(country).enterStreet(street).
                enterTown(town).enterDistrict(district).enterPostCode(postCode).
                enterPhone(phone).enterEmail(email);

    }

    public CheckoutPage placeorder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton)).click();
        return this;
    }

    public String text(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textMessage)).getText();
    }
}
