package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import models.User;
import models.UserEntity;
import repositories.UserRepository;
import services.UserService;

public class UserApiFlowTest 
{
	@Test
	public void createUserAndValidateDatabase()
	{
		User user = new User("Alexander", "QA Analyst");
		
		UserService service = new UserService();		
		Response response = service.createUser(user);
		
		int id = response.jsonPath().getInt("id");
		
		UserEntity entity = new UserEntity();
		
		entity.setId(id);
		entity.setName("Alexander");
		entity.setJob("QA Analyst");
		
		UserRepository repo = new UserRepository();
		repo.saveUser(entity);
		
		UserEntity dbUser = repo.findUserById(id);
		
		Assert.assertEquals(dbUser.getName(), "Alexander");
		Assert.assertEquals(dbUser.getJob(), "QA Analyst");
		
		System.out.println("Database validation passed");
		
	}
}
