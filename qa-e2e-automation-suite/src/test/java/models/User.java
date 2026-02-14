package models;

public class User 
{
	private String id;
	private String name;
	private String job;
	
	public User() {}
	
	public User(String name, String job)
	{
		this.name = name;
		this.job = job;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getJob()
	{
		return job;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setJob(String job)
	{
		this.job = job;
	}
}
