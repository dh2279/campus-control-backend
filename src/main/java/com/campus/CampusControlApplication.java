package com.campus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampusControlApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(CampusControlApplication.class, args);
		System.err.println("App is started...");
	}

}
