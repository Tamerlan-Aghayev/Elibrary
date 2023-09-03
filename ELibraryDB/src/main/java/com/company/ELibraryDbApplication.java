package com.company;

import com.company.service.BookService;
import com.company.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ELibraryDbApplication {
	@Autowired
	BookService book;
	public static void main(String[] args) {
		SpringApplication.run(ELibraryDbApplication.class, args);
	}


	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception{
				System.out.println(book.getByName("tamerlan").getName());
			}
		};

		return clr;
	}
}

