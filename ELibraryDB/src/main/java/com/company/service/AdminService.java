package com.company.service;

import com.company.entity.AdminEntity;
import com.company.entity.PrivilegeEntity;
import com.company.repository.AdminRepository;
import com.company.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PrivilegeService privilegeService;
    private static BCryptPasswordEncoder crypt=new BCryptPasswordEncoder();

    public List<AdminEntity> getAll(){
        return adminRepository.findAll();

    }
    public AdminEntity getAdminByUsername(String username){
        return adminRepository.getAdminByUSername(username);
    }
    public void addAdmin(AdminEntity admin, String password){
        PrivilegeEntity privilegeEntity=new PrivilegeEntity();
        privilegeEntity.setUsername(admin.getUsername());
        privilegeEntity.setPassword(crypt.encode(password));
        privilegeEntity.setPrivilege("ADMIN");
        privilegeService.addPrivilege(privilegeEntity);
        adminRepository.saveAndFlush(admin);

    }public void deleteById(int id){
        adminRepository.deleteById(id);
    }
}
