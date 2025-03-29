package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
				features="src/test/resource/features",				//feature files path
				glue={"stepDefination","hooks"},											//only package name
				plugin={
							"pretty","html:target/CucumberReports/cucuReport.html",		//will provide details in console in colored
							"html:target/CucumberReports/cucuReport.json",
							"html:target/CucumberReports/cucuReport.xml"				////will print report in respective files
					    },
		
				tags="",								//will use tags from feature file and run mentioned here
				dryRun=false,							//checks mapping between scenario steps and step definition methods, dont do actual execution
				publish=true,								//will publish report on cloud with 24 hrs validity
				monochrome=true 
				
				)


public class TestMyRunner 
{
	

}
