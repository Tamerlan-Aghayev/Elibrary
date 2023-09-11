package com.company.dto;

import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {
    private int id;
    private String name;
    private String address;
    private String email;

    private List<BookInLibraryDTO> books;
    public LibraryDTO(){}

    public LibraryDTO(LibraryEntity library) {
        this.id = library.getId();
        this.name = library.getName();
        this.address = library.getAddress();
        this.email = library.getEmail();

        List<BookEntity> list = library.getBooksById();
        if (list != null) {
            List<BookInLibraryDTO> dto = new ArrayList<>();

            for (BookEntity l : list) {
                dto.add(new BookInLibraryDTO(l));

            }
            this.books = dto;
        }
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

    public List<BookInLibraryDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookInLibraryDTO> books) {
        this.books = books;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
