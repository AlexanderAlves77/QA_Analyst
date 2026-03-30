package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.MLDataCollector;

public class TestFailureListener implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("### ML Engine: Capturando dados da falha para treinamento...");
		MLDataCollector.logFailure(result, "TO_CLASSIFY");
		System.out.println("### Dados salvos em target/ml_failure_data.csv");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Iniciando Teste: " + result.getName());
	}
}
