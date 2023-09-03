package com.company.dto;


import com.company.entity.BookEntity;

public class BookDTO {
    private int id;
    private String name;

    private String status;

    private String author;

    private String libraryName;
    private String libraryAddress;
    private MemberDTO memberDTO;
    public BookDTO(){

    }
    public BookDTO(BookEntity book){
        this.author=book.getAuthor();
        this.status=book.getStatus();
        this.id=book.getId();
        this.libraryAddress=book.getLibraryByLibraryId().getAddress();
        this.name=book.getName();
        this.libraryName=book.getLibraryByLibraryId().getName();
        this.memberDTO=new MemberDTO(book.getUserByUserId());
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
