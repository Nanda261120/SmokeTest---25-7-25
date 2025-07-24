package Cucumber_TC_Creation;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Runner {
	
	@CucumberOptions(
			features = {"src/main/java/Cucumber_TC_Creation/Navigation.feature"},
			dryRun = !true,
			glue = {"screens"},
			snippets = SnippetType.CAMELCASE,
	    	monochrome = true
					)
	public class Runnerclass extends AbstractTestNGCucumberTests{



	}

}
