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
	
	public UserResponseDTO() {}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getJobTitle() { return jobTitle; }
	public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
	
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	
	public Boolean getActive() { return active; }
	public void setActive(Boolean active) { this.active = active; }
	
	public Integer getAge() { return age; }
	public void setAge(Integer age) { this.age = age; }
	
	public LocalDateTime getCreatedAt() { return createdAt; }
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
	
	public LocalDateTime getUpdatedAt() { return updatedAt; }
	public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
	
	
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
