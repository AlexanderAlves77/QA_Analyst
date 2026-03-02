package com.rubeus.qa.listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;


public class QAListener implements TestWatcher
{
	@Override 
	public void testSuccessful(ExtensionContext context) 
	{	
		System.out.println("Test passed: " + context.getDisplayName());
	}
	
	@Override 
	public void testFailed(ExtensionContext context, Throwable cause) 
	{
		System.out.println("Test failed: " + context.getDisplayName());
	}
}
