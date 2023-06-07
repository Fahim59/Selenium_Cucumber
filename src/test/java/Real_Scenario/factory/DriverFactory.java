package Real_Scenario.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class DriverFactory {
    //private static WebDriver driver;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default: throw new IllegalStateException("INVALID BROWSER" +browser);
        }
        DriverFactory.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver(){
        //return driver;
        return driver.get();
    }
}
