package Real_Scenario.hooks;

import Real_Scenario.factory.DriverFactory;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class MyHooks {
    private static WebDriver driver;

    @Before
    public static void before(){
        driver = DriverFactory.initializeDriver();
    }

    @AfterStep
    public static void Screenshoot(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");

            File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "github");

            File destinationPath = new File("target/Failed_Scenario/FailedScreenshots/" + screenshotName + ".jpg");
            FileUtils.copyFile(image, destinationPath);
        }
    }

    @After
    public static void after(Scenario scenario){
        driver.quit();
    }
}
