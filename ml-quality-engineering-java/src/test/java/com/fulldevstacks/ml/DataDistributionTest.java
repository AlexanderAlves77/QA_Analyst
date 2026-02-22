package com.fulldevstacks.ml;

import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.stream.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import io.qameta.allure.*;


public class DataDistributionTest 
{
	@Test
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Verify Class Distribution")
	@Description("Ensure that the dataset contains both fraud (1) and legitimate (0) cases.")
	@Story("Class Balance")
	void testClassDistribution() throws IOException 
	{
		Path path = Paths.get("src/test/resources/creditcard.csv");
		
		try (Stream<String> lines = Files.lines(path)) 
		{
			Map<String, Long> counts = lines.skip(1)
					.map(line -> line.split(",")[30].replace("\"", "").trim()) 
					.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
					
			// Ensure that we have both types of transaction
			Assertions.assertThat(counts).containsKey("0").containsKey("1");
			
			System.out.println("Legitimate: " + counts.get("0"));
			System.out.println("Frauds    : " + counts.get("1"));
			
			saveLog(counts.toString());
			
			Path imagePath = Paths.get("src/test/resources/distribution_chart.png");
			if (Files.exists(imagePath)) {
				saveScreenshot(Files.readAllBytes(imagePath));
			}
			
			Assertions.assertThat(counts).containsKey("0").containsKey("1");
		}
		catch (IOException ex) {}
	}
	
	@Attachment(value = "Distribution Log", type = "text/plain")
	public String saveLog(String message)
	{
		return message;
	}
	
	@Attachment(value = "Distribution Visualization", type = "image/png")
	public byte[] saveScreenshot(byte[] screenshot) 
	{
		return screenshot;
	}
}
