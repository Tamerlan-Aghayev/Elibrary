package com.company.dto;

import com.company.entity.BookEntity;



public class BookDTO {
    private int id;
    private String name;


    private String authorName;
    private String authorSurname;
    private int authorBirthYear;

    private String authorNationality;
    private String authorCountry;
    private String libraryName;
    private String libraryAddress;
    public BookDTO(){

    }
    public BookDTO(BookEntity book){
        this.authorBirthYear=book.getAuthorByAuthorId().getBirthYear();
        this.id=book.getId();
        this.authorCountry=book.getAuthorByAuthorId().getNationalityByCountryId().getCountry();
        this.libraryAddress=book.getLibraryByLibraryId().getAddress();
        this.authorName=book.getAuthorByAuthorId().getName();
        this.name=book.getName();
        this.authorSurname=book.getAuthorByAuthorId().getSurname();
        this.libraryName=book.getLibraryByLibraryId().getName();
        this.authorNationality=book.getAuthorByAuthorId().getNationalityByNationalityId().getNationality();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public int getAuthorBirthYear() {
        return authorBirthYear;
    }

    public void setAuthorBirthYear(int authorBirthYear) {
        this.authorBirthYear = authorBirthYear;
    }

    public String getNationality() {
        return authorNationality;
    }

    public void setNationality(String nationality) {
        this.authorNationality = nationality;
    }

    public String getCountry() {
        return authorCountry;
    }

    public void setCountry(String country) {
        this.authorCountry = country;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }




}
