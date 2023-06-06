package Real_Scenario.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@role='combobox']") private WebElement textField;
    @FindBy(xpath = "//input[@id='billing_first_name']") private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='billing_last_name']") private WebElement lastNameField;
    @FindBy(xpath = "//span[@id='select2-billing_country-container']") private WebElement countryField;
    @FindBy(xpath = "//input[@id='billing_address_1']") private WebElement streetField;
    @FindBy(xpath = "//input[@id='billing_city']") private WebElement townField;
    @FindBy(xpath = "//span[@id='select2-billing_state-container']") private WebElement districtField;
    @FindBy(xpath = "//input[@id='billing_postcode']") private WebElement postCodeField;
    @FindBy(xpath = "//input[@id='billing_phone']") private WebElement phoneField;
    @FindBy(xpath = "//input[@id='billing_email']") private WebElement emailField;

    @FindBy(xpath = "//button[@id='place_order']") private WebElement placeOrderButton;

    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']") private WebElement textMessage;

    public CheckoutPage enterFirstName(String firstName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(firstNameField));
        element.clear();
        element.sendKeys(firstName);

        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(lastNameField));
        element.clear();
        element.sendKeys(lastName);

        return this;
    }

    public CheckoutPage enterCountry(String country){
        wait.until(ExpectedConditions.visibilityOf(countryField)).click();
        wait.until(ExpectedConditions.visibilityOf(textField)).sendKeys(country, Keys.ENTER);

        return this;
    }

    public CheckoutPage enterStreet(String street){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(streetField));
        element.clear();
        element.sendKeys(street);

        return this;
    }

    public CheckoutPage enterTown(String town){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(townField));
        element.clear();
        element.sendKeys(town);

        return this;
    }

    public CheckoutPage enterDistrict(String district){
        wait.until(ExpectedConditions.visibilityOf(districtField)).click();
        wait.until(ExpectedConditions.visibilityOf(textField)).sendKeys(district, Keys.ENTER);

        return this;
    }

    public CheckoutPage enterPostCode(String postCode){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(postCodeField));
        element.clear();
        element.sendKeys(postCode);

        return this;
    }

    public CheckoutPage enterPhone(String phone){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(phoneField));
        element.clear();
        element.sendKeys(phone);

        return this;
    }

    public CheckoutPage enterEmail(String email){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(emailField));
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
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton)).click();
        return this;
    }

    public String text(){
        return wait.until(ExpectedConditions.visibilityOf(textMessage)).getText();
    }
}
