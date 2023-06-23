package com.company.service;


import com.company.entity.BookEntity;
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
    public List<BookEntity> getAll(){
        return bookRepository.findAll();
    }

    public BookEntity getByName(String name){
        return bookRepository.findByName(name);
    }
    public void addBook(BookEntity book){
        bookRepository.saveAndFlush(book);
    }
    public void deleteBook(String name){
        BookEntity book=getByName(name);
        bookRepository.delete(book);
    }
}
