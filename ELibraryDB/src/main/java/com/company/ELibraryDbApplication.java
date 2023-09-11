package com.company;

import com.company.entity.UserEntity;
import com.company.service.BookService;
import com.company.service.LibraryService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ELibraryDbApplication {
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ELibraryDbApplication.class, args);
	}


	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception{
//				UserEntity user=new UserEntity("salam", "salamov", "123rf1e", "email", "siazan");
//				userService.registerUser(user, "salam");
			}
		};

		return clr;
	}
}

