package Real_Scenario;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions
        (
                plugin = {"pretty","html:target/TestNG_Cucumber.html", "summary"},
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                dryRun = true
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