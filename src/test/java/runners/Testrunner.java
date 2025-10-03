package runners;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepDefinitions"},
	    plugin = {
	            "pretty",
	            "html:target/cucumber-html-report",
	            "json:target/cucumber.json"
	        },
	        monochrome = true
	)
	public class Testrunner extends AbstractTestNGCucumberTests {
	}

	
