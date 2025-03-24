package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks
{
	public WebDriver driver;
	public Properties prop;
	public ConfigReader configReader;

	@Before
	public void setUp()
	{
		configReader=new ConfigReader();
		prop = configReader.initilizeProperties();
		
		driver=DriverFactory.initilizeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName=scenario.getName().replace(" ", "_");
		if(scenario.isFailed())
		{
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		driver.quit();
	
	}

}
