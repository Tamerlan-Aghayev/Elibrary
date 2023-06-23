package com.company.service;

import com.company.entity.AuthorEntity;
import com.company.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public List<AuthorEntity> getAll(){
        return authorRepository.findAll();
    }
    public AuthorEntity getByName(String name, String surname){
        return authorRepository.findByName(name, surname);
    }
    public void addAuthor(AuthorEntity author){
        authorRepository.saveAndFlush(author);
    }
    public void deleteAuthor(String name, String surname){
        AuthorEntity author=getByName(name, surname);
        authorRepository.delete(author);
    }
}
