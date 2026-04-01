package com.fulldevstacks.api.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
	
	@Given("I have a valid user payload")
	public void i_have_a_valid_user_payload() {
		userPayload = "{ \\\"name\\\": \\\"Alex\\\", \\\"email\\\": \\\"alex@test.com\\\" }";
	}
	
	@When("I send a POST request to {string}")
	public void i_send_a_post_request_to(String endpoint) 
	{
		response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(userPayload)
				.post("http://localhost:8080" + endpoint);
	}
	
	@Then("the status code should be 201")
	public void the_status_code_should_be() {
		response.then().statusCode(201);
	}
	
	@Then("the user should be persisted in the database")
	public void verifyPersistence() 
	{
		boolean exists = userRepository.existsByEmail("alex@test.com");
		Assertions.assertThat(exists).isTrue();
	}
}
