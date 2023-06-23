package com.company.controller;

import com.company.dto.LibraryDTO;
import com.company.dto.NationalityDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.LibraryEntity;
import com.company.entity.NationalityEntity;
import com.company.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;
    private ResponseDTO response=new ResponseDTO();
    @GetMapping("/libraries")
    public ResponseEntity<ResponseDTO> getLibraries(){
        try {
            List<LibraryEntity> list = libraryService.getAll();
            List<LibraryDTO> dto = new ArrayList<>();
            for (LibraryEntity n : list) {
                dto.add(new LibraryDTO(n));

            }
            response=ResponseDTO.of(dto, "success");
        }
        catch(Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of( "success");
        }


        return ResponseEntity.ok(response);
    }
    @GetMapping("/libraryName")
    public ResponseEntity<ResponseDTO> getLibraryByName(@RequestParam("name")String name){
        try {
            LibraryEntity library = libraryService.getByName(name);
            LibraryDTO dto = new LibraryDTO(library);
            return ResponseEntity.ok(ResponseDTO.of(dto, "success"));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ResponseDTO.of( "error"));
        }
    }
    @GetMapping("/libraryAddress")
    public ResponseEntity<ResponseDTO> getLibraryByAddress(@RequestParam("address")String address){
        try {
            LibraryEntity library = libraryService.getByAddress(address);
            LibraryDTO dto = new LibraryDTO(library);
            return ResponseEntity.ok(ResponseDTO.of(dto, "success"));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ResponseDTO.of( "error"));
        }
    }
    @PostMapping("/library")
    public ResponseEntity<String> addLibrary(LibraryDTO libraryDTO){
        try {
            LibraryEntity library = new LibraryEntity();
            library.setAddress(libraryDTO.getAddress());
            library.setName(libraryDTO.getName());
            libraryService.addLibrary(library);
            return ResponseEntity.ok("success");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok("error");
        }
    }
    @DeleteMapping("/libraryName")
    public ResponseEntity<String> deleteLibraryByName(@RequestParam("name") String name){
        try{
            libraryService.deleteLibraryByName(name);
            return ResponseEntity.ok("success");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok("failure");
        }
    }
    @DeleteMapping("/libraryAddress")
    public ResponseEntity<String> deleteLibraryByAddress(@RequestParam("address") String address){
        try{
            libraryService.deleteLibraryByAddress(address);
            return ResponseEntity.ok("success");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok("failure");
        }
    }
}
