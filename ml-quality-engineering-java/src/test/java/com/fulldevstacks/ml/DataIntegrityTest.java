package com.fulldevstacks.ml;

import java.io.IOException;
import java.nio.file.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.assertj.core.api.Assertions;
import java.util.concurrent.atomic.AtomicLong;


public class DataIntegrityTest 
{
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Check for Missing Values")
	@Description("Verify that there are no null or empty values in the feature columns.")
	@Story("Data Cleaning")
	void testNoNullValuesInCriticalColumns() throws IOException 
	{
		Path path = Paths.get("src/test/resources/creditcard.csv");
		AtomicLong rowCount = new AtomicLong(0);
		
		Files.lines(path).skip(1).forEach(line -> {
			rowCount.incrementAndGet();
			String[] columns = line.split(",");
			Assertions.assertThat(columns[29]).as("Amount at row " + rowCount).isNotEmpty();
			Assertions.assertThat(columns[30]).as("Class at row " + rowCount).isNotEmpty();
		});
	}
}
