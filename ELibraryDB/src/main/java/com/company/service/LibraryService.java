package com.company.service;

import com.company.entity.LibraryEntity;
import com.company.entity.PrivilegeEntity;
import com.company.repository.LibraryRepository;

import com.company.repository.UserLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private PrivilegeService privilegeService;
    private static BCryptPasswordEncoder crypt=new BCryptPasswordEncoder();
    public List<LibraryEntity> getAll(){
        return libraryRepository.findAll();
    }
    public LibraryEntity getByName(String name){
        return libraryRepository.findByName(name);
    }
    public LibraryEntity getByUsername(String username){
        return libraryRepository.findByEmail(username);
    }
    public LibraryEntity getByAddress(String address){
        return libraryRepository.findByAddress(address);
    }
    public void addLibrary(LibraryEntity library ,String password){
        PrivilegeEntity privilegeEntity=new PrivilegeEntity();
        privilegeEntity.setUsername(library.getEmail());
        privilegeEntity.setPassword(crypt.encode(password));
        privilegeEntity.setPrivilege("LIBRARY");
        privilegeService.addPrivilege(privilegeEntity);
        libraryRepository.saveAndFlush(library);
    }
    public void deleteLibraryByName(String name){
        LibraryEntity library=getByName(name);
        PrivilegeEntity privilegeEntity=privilegeService.getByUsername(library.getEmail());
        privilegeService.deletePrivilege(privilegeEntity);
        userLibraryService.deleteAllUsers(library);
        libraryRepository.delete(library);

    }

}
