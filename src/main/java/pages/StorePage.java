package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By menLink = By.xpath("//li[@id='menu-item-1228']//a[@class='menu-link'][normalize-space()='Men']");
    private final By viewCartLink = By.xpath("//a[@title='View cart']");

    public void clickMenLink(){
        wait.until(ExpectedConditions.elementToBeClickable(menLink)).click();
    }

    public void addToCart(String productName){
        By addTocartBtn = By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");

        wait.until(ExpectedConditions.elementToBeClickable(addTocartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
