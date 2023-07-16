package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By productName = By.xpath("//td[@class='product-name']");
    private final By proQuantity = By.xpath("//input[@title='Qty']");
    private final By checkoutButton = By.xpath("//a[@class='checkout-button button alt wc-forward']");

    private final By couponField = By.xpath("//input[@id='coupon_code']");
    private final By couponBtn = By.xpath("//button[@name='apply_coupon']");
    private final By couponText = By.xpath("//div[@role='alert']");

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOfElementLocated(proQuantity)).getAttribute("value"));
    }

    public void checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public CartPage enterCoupon(String coupon){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(couponField));
        element.clear();
        element.sendKeys(coupon);

        return this;
    }

    public CartPage clickApplyCoupon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponBtn)).click();
        return this;
    }

    public String text(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(couponText)).getText();
    }
}