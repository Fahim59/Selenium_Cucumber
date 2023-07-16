package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By accountLink = By.xpath("//li[@id='menu-item-1237']//a[@class='menu-link'][normalize-space()='Account']");

    private final By userNameField = By.xpath("//input[@id='reg_username']");
    private final By emailField = By.xpath("//input[@id='reg_email']");
    private final By passwordField = By.xpath("//input[@id='reg_password']");

    private final By loginUserNameField = By.xpath("//input[@id='username']");
    private final By loginPasswordField = By.xpath("//input[@id='password']");

    private final By loginBtn = By.xpath("//button[@name='login']");
    private final By registerBtn = By.xpath("//button[@name='register']");

    private final By textMessage = By.xpath("//p[contains(text(),'Hello')]");

    public void clickAccountLink(){
        wait.until(ExpectedConditions.elementToBeClickable(accountLink)).click();
    }

    public AccountPage enterUserName(String userName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        element.clear();
        element.sendKeys(userName);

        return this;
    }

    public AccountPage enterEmail(String email){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.clear();
        element.sendKeys(email);

        return this;
    }

    public AccountPage enterPassword(String password){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        element.clear();
        element.sendKeys(password);

        return this;
    }

    public AccountPage enterLoginUserName(String userName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginUserNameField));
        element.clear();
        element.sendKeys(userName);

        return this;
    }

    public AccountPage enterLoginPassword(String password){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPasswordField));
        element.clear();
        element.sendKeys(password);

        return this;
    }

    public void clickRegisterBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
    }

    public void clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public AccountPage setRegistrationDetails(String userName, String password, String email){
        return enterUserName(userName).enterPassword(password).enterEmail(email);
    }

    public AccountPage enterLoginDetails(String userName, String password){
        return enterLoginUserName(userName).enterLoginPassword(password);
    }

    public String text(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textMessage)).getText();
    }
}
