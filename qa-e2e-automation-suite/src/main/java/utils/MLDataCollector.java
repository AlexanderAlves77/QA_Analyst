package utils;

import org.testng.ITestResult;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MLDataCollector 
{
	private static final String CSV_FILE = "target/ml_failure_data.csv";
	
	public static void logFailure(ITestResult result, String failureType) 
	{
		// Criar cabeçalho se o arquivo não existir
		if (!Files.exists(Paths.get(CSV_FILE))) {
			saveToCSV("Exception_Class,ErrorMessage,ExecutionTime,FailureType\n");
		}
		
		String exceptionClass = result.getThrowable().getClass().getSimpleName();
		String errorMessage = result.getThrowable().getMessage().replace(",", ";").replace("\n", " ");
		long duration = result.getEndMillis() - result.getStartMillis();
		
		// Linha de dados para o Dataset: Feature1, Feature2, Feature3, Label
		String dataLine = String.format("%s,%s,%d,%s\n", exceptionClass, errorMessage, duration, failureType);
		saveToCSV(dataLine);
	}
	
	private static void saveToCSV(String data) 
	{
		try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
			writer.append(data);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
