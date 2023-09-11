package com.company.service;

import com.company.entity.LibraryEntity;
import com.company.entity.PrivilegeEntity;
import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLibraryService userLibraryService;
    @Autowired
    private PrivilegeService privilegeService;
    private static BCryptPasswordEncoder crypt=new BCryptPasswordEncoder();
    public List<UserEntity> getALL(LibraryEntity library) {
        return userRepository.getAll(library);
    }
    public UserEntity getUser(String name, String surname, LibraryEntity library){
        return userRepository.getUser(name, surname, library);
    }
    public UserEntity getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }


    public void addUser(String name, String surname, String username, String fin, String address, LibraryEntity library){
        UserEntity user=userRepository.getByFin(name, surname, username, fin, address);

        userLibraryService.add(user, library);
    }
    public void registerUser(UserEntity user, String password){
        userRepository.saveAndFlush(user);
        PrivilegeEntity privilegeEntity=new PrivilegeEntity();
        privilegeEntity.setUsername(user.getUsername());
        privilegeEntity.setPassword(crypt.encode(password));
        privilegeEntity.setPrivilege("USER");
        privilegeService.addPrivilege(privilegeEntity);

    }
    public void deleteUser(UserEntity user , LibraryEntity library){
        userLibraryService.delete(user, library);
        PrivilegeEntity privilegeEntity=privilegeService.getByUsername(user.getUsername());
        privilegeService.deletePrivilege(privilegeEntity);
        userRepository.delete(user);
    }
}
