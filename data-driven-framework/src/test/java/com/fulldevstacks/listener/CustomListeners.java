package com.fulldevstacks.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.fulldevstacks.utilities.TestUtil;

public class CustomListeners implements ITestListener
{
	// Invocado antes de qualquer teste ser iniciado
    @Override
    public void onStart(ITestContext context) 
    {
        System.out.println(">>> Iniciando Suite de Testes: " + context.getName());
    }

    // Invocado após todos os testes da suíte terminarem
    @Override
    public void onFinish(ITestContext context) 
    {
        System.out.println(">>> Suite de Testes Finalizada: " + context.getName());
    }

    // Invocado quando um método de teste começa
    @Override
    public void onTestStart(ITestResult result) 
    {
        System.out.println("Teste Iniciado: " + result.getName());
    }

    // Invocado quando um método de teste passa com sucesso
    @Override
    public void onTestSuccess(ITestResult result) 
    {
        System.out.println("Teste Passou: " + result.getName());
    }

    // Invocado quando um método de teste falha (Ideal para Screenshots)
    @Override
    public void onTestFailure(ITestResult result) 
    {
    	System.setProperty("org.uncommons.reportng.escape-output", "false");
    	try 
    	{
    		TestUtil.captureScreenshot();
    	}
    	catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    	Reporter.log("Capturing screenshot");
    	Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
    	Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" width=200 height=200></img></a>");
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
        System.out.println("Teste Pulado: " + result.getName());
    }
}
