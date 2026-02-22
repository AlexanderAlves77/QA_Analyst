package com.fulldevstacks.ml;

import java.io.IOException;
import java.nio.file.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.assertj.core.api.Assertions;


public class DataSchemaTest 
{
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@DisplayName("Validate CSV Schema")
	@Description("Check if all required columns (Time, V1-V28, Amount, Class) are present in the dataset.")
	@Story("Data Structure")
	void testCsvColumnPresence() throws IOException 
	{
		Path path = Paths.get("src/test/resources/creditcard.csv");
		String header = Files.lines(path).findFirst().orElse("");
		
		Assertions.assertThat(header).contains("Time", "Amount", "Class");
		Assertions.assertThat(header.split(",")).hasSize(31);
	}
}
