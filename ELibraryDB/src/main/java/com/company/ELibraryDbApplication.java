package com.company;

import com.company.entity.AuthorEntity;
import com.company.entity.LibraryEntity;
import com.company.entity.NationalityEntity;
import com.company.service.AuthorService;
import com.company.service.BookService;
import com.company.service.LibraryService;
import com.company.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ELibraryDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELibraryDbApplication.class, args);
	}
	@Autowired
	public LibraryService libraryService;
	@Autowired
	public NationalityService nationalityService;
	@Autowired
	public AuthorService authorService;

	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {
//				NationalityEntity n=new NationalityEntity();
//				n.setCountry("Azerbaijan");
//				n.setNationality("Azerbaijani");
//				nationalityService.addNationality(n);
//				AuthorEntity a=new AuthorEntity();
//				a.setBirthYear(2000);
//				a.setName("tahir");
//				a.setSurname("salamov");
//				a.setNationalityByCountryId(nationalityService.getByCountry("Azerbaijan"));
//				a.setNationalityByNationalityId(nationalityService.getByNationality("Azerbaijani"));

			}
		};

		return clr;
	}
}

