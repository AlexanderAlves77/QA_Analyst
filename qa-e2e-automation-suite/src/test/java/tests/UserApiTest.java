package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.User;
import services.UserService;

public class UserApiTest 
{
	UserService userService = new UserService();
	
	@Test
	public void createUserTest()
	{
		User user = new User("Alexander", "QA Analyst");
		
		Response response = userService.createUser(user);
		
		System.out.println(response.getBody().asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
