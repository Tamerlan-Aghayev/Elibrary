package com.company.service;

import com.company.entity.PrivilegeEntity;
import com.company.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrivilegeService {
    @Autowired
    private PrivilegeRepository privilegeRepository;
    public List<PrivilegeEntity> getUsers(){
        return privilegeRepository.getUsers();
    }
    public List<PrivilegeEntity> getAdmins(){
        return privilegeRepository.getAdmins();
    }
    public PrivilegeEntity getByUsernamePassword(String username, String password){
        return privilegeRepository.getByUsernamePassword(username, password);
    }
    public PrivilegeEntity getByUsername(String username){
        return privilegeRepository.getByUsername(username);
    }
    public void addPrivilege(PrivilegeEntity privilegeEntity){
        privilegeRepository.saveAndFlush(privilegeEntity);
    }
    public void deletePrivilege(PrivilegeEntity privilegeEntity){
        privilegeRepository.delete(privilegeEntity);
    }


}
