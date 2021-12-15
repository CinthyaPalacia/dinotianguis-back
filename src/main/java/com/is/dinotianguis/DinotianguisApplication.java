package com.is.dinotianguis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DinotianguisApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DinotianguisApplication.class, args);
	}

}
