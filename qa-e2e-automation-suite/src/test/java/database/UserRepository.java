package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.User;

public class UserRepository 
{
	private PreparedStatement getConn(String sql)
	{
		try
		{
			Connection conn = DatabaseManager.getConnection();			
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		}		
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	public void saveUser(User user)
	{
		String sql = "INSERT INTO users (name, job) VALUES (?, ?)";
		
		try 
		{
			PreparedStatement stmt = getConn(sql);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getJob());
			stmt.executeUpdate();			
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	public boolean userExists(String name)
	{
		String sql = "SELECT * FROM users WHERE name = ?";
		
		try
		{
			PreparedStatement stmt = getConn(sql);
			
			stmt.setString(1, name);
			ResultSet res = stmt.executeQuery();	
			
			return res.next();
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
