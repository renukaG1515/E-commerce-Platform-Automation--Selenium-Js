package runners;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "src/main/java/stepDefinitions",
	    plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
	)
	public class Testrunner extends AbstractTestNGCucumberTests {
	}

	
