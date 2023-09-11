package com.company.service;


import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import com.company.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public BookEntity getByNameByLibrary(String name, LibraryEntity library){
        return bookRepository.findByName(name, library);
    }
    public void addBook(BookEntity book, LibraryEntity library){
        book.setStatus("available");
        book.setLibraryByLibraryId(library);
        bookRepository.saveAndFlush(book);
    }
    public void deleteBook(String name, LibraryEntity library){
        BookEntity book=bookRepository.findByName(name, library);
        bookRepository.delete(book);
    }
    public void setUnavailable(UserEntity user, String name, LibraryEntity library){
        BookEntity book=bookRepository.findByName(name, library);
        book.setUserByUserId(user);
        book.setStatus("unavailable");
        bookRepository.saveAndFlush(book);
    }
    public void setAvailable(String name, LibraryEntity library){
        BookEntity book=bookRepository.findByName(name, library);
        book.setUserByUserId(null);
        book.setStatus("available");
        bookRepository.saveAndFlush(book);

    }
    public void DeleteAllBooks(LibraryEntity library){
        List<BookEntity> books =bookRepository.findByLibrary(library);
        for(BookEntity book : books){
            deleteBook(book.getName(), library);
        }
    }
}
