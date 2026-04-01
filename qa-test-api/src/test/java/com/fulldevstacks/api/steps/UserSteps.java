package com.fulldevstacks.api.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.Before;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fulldevstacks.qa_test_api.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserSteps 
{
	@Autowired
	private UserRepository userRepository;
	
	private Response response;
	private String userPayload;
	private String lastGeneratedEmail;
	
	// Hook para limpar o banco ANTES de cada cenário
    @Before
    public void cleanDatabase() {
    	userRepository.deleteAll();
    }
    	
	@Given("I have a valid user payload")
	public void i_have_a_valid_user_payload() 
	{
		// Gerando e-mail único para garantir que o teste seja único
		lastGeneratedEmail = "alexander." + System.currentTimeMillis() + "@test.com";
		
		userPayload = """
			    {
			        "name": "Alexander Alves",
			        "email": "%s",
			        "jobTitle": "QA Engineer",
			        "phone": "(21) 99999-9999",
			        "age": 30,
			        "active": true
			    }
			    """.formatted(lastGeneratedEmail);
	}
	
	@When("I send a POST request to {string}")
	public void i_send_a_post_request_to(String endpoint) 
	{
		response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(userPayload)
				.post("http://localhost:8090" + endpoint);
	}
	
	@Then("the status code should be 201")
	public void the_status_code_should_be() {
		response.then().statusCode(201);
	}
	
	@Then("the user should be persisted in the database")
	public void verifyPersistence() 
	{
		boolean exists = userRepository.existsByEmail(lastGeneratedEmail);
		Assertions.assertThat(exists)
			.withFailMessage("O usuário com e-mail " + lastGeneratedEmail + " não foi encontrado no banco.")
			.isTrue();
	}
}
