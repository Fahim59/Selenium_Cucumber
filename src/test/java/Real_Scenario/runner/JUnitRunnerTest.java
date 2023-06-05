package Real_Scenario.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/resources/Real_Scenario/datatable.feature",
                glue = "Real_Scenario.stepDef",
                plugin = {"pretty","html:target/JUnit_Cucumber.html", "summary"},
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                //dryRun = true,
                //monochrome = true,
                tags = "@Eight"
        )
public class JUnitRunnerTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("\nBEFORE CLASS\n");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("\nAFTER CLASS\n");
    }
}
