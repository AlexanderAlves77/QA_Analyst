package com.fulldevstacks.qa_test_api.dto;

import java.time.LocalDateTime;
import com.fulldevstacks.qa_test_api.entity.User;
import lombok.Data;

@Data
public class UserResponseDTO 
{
	private Long id;
	private String name;
	private String email;
	private String jobTitle;
	private String phone;
	private Integer age;
	private Boolean active;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public static UserResponseDTO fromEntity(User user)
	{
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setJobTitle(user.getJobTitle());
		dto.setPhone(user.getPhone());
		dto.setAge(user.getAge());
		dto.setActive(user.getActive());
		dto.setCreatedAt(user.getCreatedAt());
		dto.setUpdatedAt(user.getUpdatedAt());
		return dto;
	}
}
