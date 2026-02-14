package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager 
{
	private static Properties properties;
	
	static 
	{
		try
		{
			properties = new Properties();
			
			FileInputStream file = new FileInputStream("src/test/resources/config.properties");
			
			properties.load(file);
		}
		catch (IOException ex)
		{
			throw new RuntimeException("Erro ao carregar config.properties");
		}
	}
	
	public static String getBaseUrl() 
	{
		return properties.getProperty("base.url");
	}
	
	public static String getBrowser() 
	{
		return properties.getProperty("browser");
	}
}
