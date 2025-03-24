package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
				features="src/test/resource/features",				//feature files path
				glue={"stepDefination","hooks"},											//only package name
				plugin={"pretty","html:target/CucumberReports/cucuReport.html"}
				
				
				)
public class TestMyRunner 
{
	

}
