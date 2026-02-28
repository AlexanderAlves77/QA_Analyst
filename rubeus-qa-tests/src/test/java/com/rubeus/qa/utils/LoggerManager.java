package com.rubeus.qa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * LoggerManager
 *
 * Provides centralized logging access.
 */
public class LoggerManager 
{
	public static Logger getLogger(Class<?> clazz) 
	{
		return LogManager.getLogger(clazz);
	}
}
