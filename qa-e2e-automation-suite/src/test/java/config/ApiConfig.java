package config;

import io.restassured.RestAssured;

public class ApiConfig 
{
	public static void setup() 
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}
}
