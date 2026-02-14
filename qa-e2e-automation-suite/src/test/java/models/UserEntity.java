package models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity 
{
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String job;
	
	public UserEntity() {}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getJob() { return job; }
	public void setJob(String job) { this.job = job; }
}
