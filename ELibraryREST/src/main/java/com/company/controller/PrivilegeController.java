package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.entity.PrivilegeEntity;
import com.company.service.AdminService;
import com.company.service.LibraryService;
import com.company.service.PrivilegeService;
import com.company.service.UserService;
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
    @Autowired
    private UserService userService;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private AdminService adminService;


    @GetMapping("/member")
    public  ResponseEntity<ResponseDTO> getUser(String username){
        return ResponseEntity.ok(ResponseDTO.of(privilegeService.getByUsername(username), "success"));
    }
    @GetMapping("/login")
    public  ResponseEntity<ResponseDTO> login(String username, String password) {
        try {
            PrivilegeEntity privilegeEntity = privilegeService.getByUsernamePassword(username, password);

            if (privilegeEntity.getPrivilege().equals("USER")) {
                return ResponseEntity.ok(ResponseDTO.of(userService.getUserByUsername(privilegeEntity.getUsername()), "success"));
            }
            else if(privilegeEntity.getPrivilege().equals("LIBRARY")){
                return ResponseEntity.ok(ResponseDTO.of(libraryService.getByUsername(privilegeEntity.getUsername()), "success"));
            }
            else if(privilegeEntity.getPrivilege().equals("ADMIN")){
                return ResponseEntity.ok(ResponseDTO.of(adminService.getAdminByUsername(privilegeEntity.getUsername()), "success"));
            }
            else{
                return ResponseEntity.ok(ResponseDTO.of( "some problem occurred"));
            }
        }
    catch(Exception ex){
        return ResponseEntity.ok(ResponseDTO.of( "error"));

    }
}
}

