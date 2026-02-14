package com.fulldevstacks.qa_test_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fulldevstacks.qa_test_api.entity.User;
import com.fulldevstacks.qa_test_api.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserRepository repo;
	
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return repo.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id)
	{
		return repo.findById(id).orElse(null);
	}
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return repo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id)
	{
		repo.deleteById(id);
	}
}
