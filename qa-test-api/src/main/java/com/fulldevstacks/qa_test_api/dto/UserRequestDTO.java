package com.fulldevstacks.qa_test_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestDTO 
{
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 100, message = "Name must be betwwen 3 and 100 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	private String jobTitle;
	
	@Pattern(regexp = "\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}", message = "Invalid phone format")
	private String phone;
	
	@Min(value = 18, message = "Age must be at least 18")
	@Min(value = 120, message = "Age must be at most 120")
	private Integer age;
	
	private Boolean active = true;
}
