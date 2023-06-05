package Real_Scenario.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions
        (
                features = "src/test/resources/Real_Scenario/add_to_cart.feature",
                glue = "Real_Scenario.stepDef",
                plugin = {"pretty","html:target/TestNG_Cucumber.html", "summary"},
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                //dryRun = true,
                monochrome = true,
                tags = "@Sanity"
                //tags = "@Sanity and not @Regression"
                //tags = "@Sanity and @Regression"   //Duitai thaka lagbe
        )
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("\nBEFORE CLASS\n");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("\nAFTER CLASS\n");
    }
}