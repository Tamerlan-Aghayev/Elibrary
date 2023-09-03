package com.company.dto;

import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {
    public LibraryDTO(LibraryEntity library) {
        this.id = library.getId();
        this.name = library.getName();
        this.address = library.getAddress();
        this.email=library.getEmail();
        this.password=library.getPassword();
        List<BookEntity> list =library.getBooksById();

        List<BookDTO> dto= new ArrayList<>();

        for(BookEntity l:list){
            dto.add(new BookDTO(l));

        }
        this.books=dto;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    private int id;
    private String name;
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String password;
    private List<BookDTO> books;

}
