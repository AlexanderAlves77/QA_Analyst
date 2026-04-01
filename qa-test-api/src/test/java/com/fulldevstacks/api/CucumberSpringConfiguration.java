package com.fulldevstacks.api;

import io.cucumber.spring.CucumberContextConfiguration;
import com.fulldevstacks.qa_test_api.QaTestApiApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = QaTestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration {

}
