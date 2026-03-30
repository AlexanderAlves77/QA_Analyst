package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import ml.FailureClassifier;
import utils.MLDataCollector;

public class TestFailureListener implements ITestListener
{
	private FailureClassifier classifier = new FailureClassifier();
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		String exceptionClass = result.getThrowable().getClass().getSimpleName();
		String errorMessage = result.getThrowable().getMessage().replace(",", ";").replace("\n", " ");
		long duration = result.getEndMillis() - result.getStartMillis();
		
		// A mágica acontece aqui: A IA analisa a falha em tempo real
		String prediction = classifier.classify(exceptionClass, errorMessage, duration);
		
		System.out.println("### [AI ADVISOR]: This failure looks like: " + prediction);
		
		// Salva para continuar refinando o dataset
		MLDataCollector.logFailure(result, prediction);
		System.out.println("### Dados salvos em target/ml_failure_data.csv");		
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Iniciando Teste: " + result.getName());
	}
}
