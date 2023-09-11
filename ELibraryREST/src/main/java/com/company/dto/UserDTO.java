package com.company.dto;

import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import com.company.entity.UserLibraryEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String surname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String fin;
    private String username;
    private String address;
    private String password;

    List <BookDTO> books=new ArrayList<>();

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public UserDTO(UserEntity entity){
        this.id=entity.getId();
        this.name= entity.getName();
        this.surname= entity.getSurname();
        this.address=entity.getAddress();
        this.fin=entity.getFin();
        this.username=entity.getUsername();
        this.address=entity.getAddress();

//        List<UserLibraryEntity> userLibraryEntities=entity.getUserLibrariesById();
//        for(int i=0;i<userLibraryEntities.size();i++) {
//            LibraryEntity library=userLibraryEntities.get(i).getLibraryByLibraryId();
//            LibraryDTO lib=new LibraryDTO(library);
//            libs.add(lib);
//        }
        List<BookEntity> bookEntities=entity.getBooksById();
        if(bookEntities!=null) {
            for (BookEntity bookEntity : bookEntities) {
                books.add(new BookDTO(bookEntity));
            }
        }

    }
    public UserDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }



    public void setSurname(String surname) {
        this.surname = surname;
    }
}
