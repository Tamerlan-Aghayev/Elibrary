package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.entity.PrivilegeEntity;
import com.company.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;
    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(){
        List<PrivilegeEntity> users=privilegeService.getUsers();
        return ResponseEntity.ok(ResponseDTO.of(users, "success"));
    }
    @GetMapping("/admins")
    public ResponseEntity<ResponseDTO> getAdmins(){
        List<PrivilegeEntity> users=privilegeService.getAdmins();
        return ResponseEntity.ok(ResponseDTO.of(users, "success"));
    }
    @GetMapping("/user")
    public  ResponseEntity<ResponseDTO> getUser(String username){
        return ResponseEntity.ok(ResponseDTO.of(privilegeService.getByUsername(username), "success"));
    }
    @GetMapping("/login")
    public  ResponseEntity<ResponseDTO> login(String username, String password){
        return ResponseEntity.ok(ResponseDTO.of(privilegeService.getByUsernamePassword(username, password), "success"));
    }
//    @PostMapping("/user")
//    public ResponseEntity<ResponseDTO> addUser()
}
