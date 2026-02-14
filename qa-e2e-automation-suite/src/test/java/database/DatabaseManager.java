package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager 
{
	private static final String URL = "jdbc:mysql://localhost:3306/qa_db";
	private static final String USER = "root";
	private static final String PASSWORD = "rska2022";
	
	public static Connection getConnection()
	{
		try
		{
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
