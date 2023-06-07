package Real_Scenario.pages;

import Real_Scenario.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void OpenWebsite(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }
}
