package com.company.service;

import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import com.company.entity.UserLibraryEntity;
import com.company.repository.UserLibraryRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLibraryService {
    @Autowired
    private UserLibraryRepository userLibraryRepository;
    public void add(UserEntity user, LibraryEntity library){
        UserLibraryEntity userLibraryEntity=new UserLibraryEntity();

        userLibraryEntity.setLibraryByLibraryId(library);
        userLibraryEntity.setUserByUserId(user);
        userLibraryRepository.saveAndFlush(userLibraryEntity);
    }
    public void delete(UserEntity user, LibraryEntity library){
        UserLibraryEntity userLibraryEntity =userLibraryRepository.getByIDs(user, library);

        userLibraryRepository.delete(userLibraryEntity);
    }
    public void deleteAllUsers(LibraryEntity library){
        List<UserLibraryEntity> users=userLibraryRepository.getByLibrary(library);
            for(UserLibraryEntity user:users){
                userLibraryRepository.delete(user);
            }
        }
    }


