package com.company.service;

import com.company.entity.LibraryEntity;
import com.company.repository.LibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    public List<LibraryEntity> getAll(){
        return libraryRepository.findAll();
    }
    public LibraryEntity getByName(String name){
        return libraryRepository.findByName(name);
    }
    public LibraryEntity getByAddress(String address){
        return libraryRepository.findByAddress(address);
    }
    public void addLibrary(LibraryEntity author){
        libraryRepository.saveAndFlush(author);
    }
    public void deleteLibraryByName(String name){
        LibraryEntity author=getByName(name);
        libraryRepository.delete(author);
    }
    public void deleteLibraryByAddress(String address){
        LibraryEntity author=getByAddress(address);
        libraryRepository.delete(author);
    }
}
