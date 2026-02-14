package com.fulldevstacks.qa_test_api.entity;

import jakarta.persistence.*;

@Entity 
@Table(name = "users")
public class User 
{
	@Id
	private Integer id;
	
	private String name;
	
	private String job;
	
	public User() {}

	public Integer getId() { return id; }
	
	public void setId(Integer id) { this.id = id; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getJob() { return job; }
	
	public void setJob(String job) { this.job = job; }
}
