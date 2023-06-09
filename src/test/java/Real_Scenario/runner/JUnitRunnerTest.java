package Real_Scenario.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/resources/Real_Scenario/add_to_cart.feature",
                glue = {"Real_Scenario.stepDef","Real_Scenario.hooks"},
                plugin = {"pretty","html:target/JUnit_Cucumber.html", "summary"},
                snippets = CucumberOptions.SnippetType.CAMELCASE
                //dryRun = true,
                //monochrome = true,
                //tags = "@Eight"
        )
public class JUnitRunnerTest { }
