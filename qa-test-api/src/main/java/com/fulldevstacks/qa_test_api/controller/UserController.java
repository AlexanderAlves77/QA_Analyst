package com.fulldevstacks.qa_test_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.fulldevstacks.qa_test_api.dto.UserRequestDTO;
import com.fulldevstacks.qa_test_api.dto.UserResponseDTO;
import com.fulldevstacks.qa_test_api.entity.User;
import com.fulldevstacks.qa_test_api.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController 
{
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequest)
	{
		// Verificar se email já existe
		if (userRepository.existsByEmail(userRequest.getEmail())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
		}
		
		User user = new User();		
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setJobTitle(userRequest.getJobTitle());
		user.setPhone(userRequest.getPhone());
		user.setAge(userRequest.getAge());
		user.setActive(userRequest.getActive());
		
		User saveUser = userRepository.save(user);
		return new ResponseEntity(UserResponseDTO.fromEntity(saveUser), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> getAllUsers()
	{
		List<UserResponseDTO> users = userRepository.findAll()
				.stream()
				.map(UserResponseDTO::fromEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(users);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id)
	{
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
		return ResponseEntity.ok(UserResponseDTO.fromEntity(user));		
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email)
	{
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with email: " + email));
		return ResponseEntity.ok(UserResponseDTO.fromEntity(user));		
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<UserResponseDTO>> getActiveUsers()
	{
		List<UserResponseDTO> users = userRepository.findByActiveTrue()
				.stream()
				.map(UserResponseDTO::fromEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(users);		
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<UserResponseDTO>> searchUserByName(@RequestParam String name)
	{
		List<UserResponseDTO> users = userRepository.findByNameContainingIgnoreCase(name)
				.stream()
				.map(UserResponseDTO::fromEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(users);		
	}
	
	@GetMapping("/age-range")
	public ResponseEntity<List<UserResponseDTO>> getUsersByAgeRange(
			@RequestParam Integer min, @RequestParam Integer max)
	{
		List<UserResponseDTO> users = userRepository.findByAgeBetween(min, max)
				.stream()
				.map(UserResponseDTO::fromEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(users);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> updateUser(
			@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequest)
	{
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

		// Verificar se o email já existe (se foi alterado)
		if (!user.getEmail().equals(userRequest.getEmail()) && 
				userRepository.existsByEmail(userRequest.getEmail()))
		{
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
		}
		
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setJobTitle(userRequest.getJobTitle());
		user.setPhone(userRequest.getPhone());
		user.setAge(userRequest.getAge());
		user.setActive(userRequest.getActive());
		
		User updateUser = userRepository.save(user);
		return ResponseEntity.ok(UserResponseDTO.fromEntity(updateUser));
	}
	
	@PatchMapping("/{id}/toggle-status")
	public ResponseEntity<UserResponseDTO> toggleUserStatus(@PathVariable Long id)
	{
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
		
		user.setActive(!user.getActive());
		User updateUser = userRepository.save(user);
		return ResponseEntity.ok(UserResponseDTO.fromEntity(updateUser));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id)
	{
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
		
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/count")
	public ResponseEntity<Long> countUsers(@RequestParam(required = false) Boolean active)
	{
		if (active != null) {
			return ResponseEntity.ok(userRepository.countByActive(active));
		}
		return ResponseEntity.ok(userRepository.count());
	}
}
