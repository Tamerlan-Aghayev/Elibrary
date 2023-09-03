package com.company.service;

import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private UserLibraryService userLibraryService;
    public List<UserEntity> getALL(LibraryEntity library) {
        return userRepository.getAll(library);
    }
    public UserEntity getUser(String name, String surname, LibraryEntity library){
        return userRepository.getUser(name, surname, library);
    }

    public void addUser(UserEntity user, LibraryEntity library){
        userRepository.saveAndFlush(user);
        userLibraryService.add(user, library);
    }
    public void deleteUser(UserEntity user , LibraryEntity library){
        userLibraryService.delete(user, library);

        userRepository.delete(user);
    }
}
