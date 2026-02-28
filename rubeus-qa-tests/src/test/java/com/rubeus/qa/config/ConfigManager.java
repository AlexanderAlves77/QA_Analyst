package com.rubeus.qa.config;

import java.io.InputStream;
import java.util.Properties;


/**
 * ConfigManager
 *
 * Enterprise configuration manager.
 *
 * Loads configuration from config.properties
 * Supports environment-based execution.
 */
public class ConfigManager 
{
	private static final String CONFIG_FILE = "config.properties";
	
	private static ConfigManager instance;
	private Properties properties;
	
	private ConfigManager() 
	{
		loadProperties();
	}
	
	/**
     * Singleton instance
     */
	public static ConfigManager getInstance()
	{
		if (instance == null) 
		{
			instance = new ConfigManager();
		}
		return instance;
	}
	
	/**
     * Load properties file
     */
	private void loadProperties()
	{
		properties = new Properties();
		
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE))
		{
			if (input == null) 
			{
				throw new RuntimeException("config.properties not found");
			}
			
			properties.load(input);
		}
		catch (Exception ex) 
		{
			throw new RuntimeException("Failed to load config.properties", ex);
		}
	}
	
	public String getBaseUrl()
	{
		return properties.getProperty("base.url");
	}
	
	public String getBrowser()
	{
		return properties.getProperty("browser", "chrome");
	}
	
	public boolean isHeadless()
	{
		return Boolean.parseBoolean(properties.getProperty("headless", "false"));
	}
	
	public Integer getTimeout()
	{
		return Integer.parseInt(properties.getProperty("timeout", "10"));
	}
}
