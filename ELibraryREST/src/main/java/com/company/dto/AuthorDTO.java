package com.company.dto;

import com.company.entity.AuthorEntity;
import com.company.entity.BookEntity;

import java.util.ArrayList;

import java.util.List;

public class AuthorDTO {
    public AuthorDTO(){

    }

    public AuthorDTO(AuthorEntity author) {
        this.name = author.getName();
        this.id = author.getId();
        this.surname = author.getSurname();
        this.birthYear = author.getBirthYear();
        this.nationality = author.getNationalityByNationalityId().getNationality();
        this.country = author.getNationalityByCountryId().getCountry();
        List<BookEntity> list =author.getBooksById();
        List<BookDTO> dto= new ArrayList<>();

        for(BookEntity l:list){
            dto.add(new BookDTO(l));

        }
        this.books=dto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String name;
    private int id;
    private String surname;
    private int birthYear;
    private String nationality;
    private String country;
    private List<BookDTO> books;

}
