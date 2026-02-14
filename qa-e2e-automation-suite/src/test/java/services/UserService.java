package services;

import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

import config.ApiConfig;

public class UserService 
{
	public Response createUser(User user)
	{
		ApiConfig.setup();
		
		return  given()
				.header("Content-Type", "application/json")
				.body(user)
				.when()
				.post("/users"); 
	}
	
	public Response getUser(int id)
	{
		ApiConfig.setup();
		
		return  given()				
				.when()
				.get("/users/" + id); 
	}
	
	public Response deleteUser(int id)
	{
		ApiConfig.setup();
		
		return  given()				
				.when()
				.delete("/users/" + id); 
	}
}
