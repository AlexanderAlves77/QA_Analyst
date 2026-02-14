package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import database.UserRepository;
import io.restassured.response.Response;
import models.User;
import services.UserService;

public class UserE2ETest 
{
	UserService userService = new UserService();
	
	UserRepository userRepository = new UserRepository();
	
	@Test
	public void fullFlowTest()
	{
		User user = new User("Alexander", "QA Analyst");
		
		Response response = userService.createUser(user);
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		userRepository.saveUser(user);
		
		boolean exists = userRepository.userExists("Alexander");
		
		Assert.assertTrue(exists);
		
		System.out.println("Usuário validado no banco com sucesso.");
	}
}
