package Real_Scenario.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@class='product-name']") private WebElement productName;

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    @FindBy(xpath = "//input[@title='Qty']") private WebElement proQuantity;

    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(proQuantity)).getAttribute("value"));
    }

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']") private WebElement checkoutButton;

    public void checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
