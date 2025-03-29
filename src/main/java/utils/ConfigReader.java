package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader 
{
	public Properties initilizeProperties()
	{
		Properties prop= new Properties();
		try 
		{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\config\\config.properties");
			prop.load(fis);
		} catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		return prop;
		
	}


}
