package com.company.service;

import com.company.entity.LibraryEntity;
import com.company.repository.LibraryRepository;

import com.company.repository.UserLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private UserLibraryService userLibraryService;

    public List<LibraryEntity> getAll(){
        return libraryRepository.findAll();
    }
    public LibraryEntity getByName(String name){
        return libraryRepository.findByName(name);
    }
    public LibraryEntity getByAddress(String address){
        return libraryRepository.findByAddress(address);
    }
    public void addLibrary(LibraryEntity library){

        libraryRepository.saveAndFlush(library);
    }
    public void deleteLibraryByName(String name){
        LibraryEntity library=getByName(name);
        userLibraryService.deleteAllUsers(library);
        libraryRepository.delete(library);

    }

}
