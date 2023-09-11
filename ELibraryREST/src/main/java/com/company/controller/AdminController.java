package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.entity.AdminEntity;
import com.company.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/admins")
    public ResponseDTO getAll(){
        return ResponseDTO.of(adminService.getAll(), "success");

    }
    @PostMapping("/admin")
    public ResponseDTO addAdmin(@RequestBody AdminEntity adminEntity, @RequestParam("password") String password){
        adminService.addAdmin(adminEntity,password);
        return ResponseDTO.of( "success");

    }
    @DeleteMapping("/admin")
    public ResponseDTO addAdmin(@RequestParam int id){
        adminService.deleteById(id);
        return ResponseDTO.of( "success");

    }
}

