package Real_Scenario;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = "message:target/cucumber-report.ndjson")
public class TestNGRunnerTest extends AbstractTestNGCucumberTests { }