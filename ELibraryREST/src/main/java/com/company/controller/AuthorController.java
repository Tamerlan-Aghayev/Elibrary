package com.company.controller;

import com.company.dto.AuthorDTO;
import com.company.dto.LibraryDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.AuthorEntity;
import com.company.entity.LibraryEntity;
import com.company.service.AuthorService;
import com.company.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private NationalityService nationalityService;
    private ResponseDTO response=new ResponseDTO();

    @GetMapping("/authors")
    public ResponseEntity<ResponseDTO> getAuthors(){
        try {
            List<AuthorEntity> list = authorService.getAll();
            List<AuthorDTO> dto = new ArrayList<>();
            for (AuthorEntity a : list) {
                dto.add(new AuthorDTO(a));
            }
            return ResponseEntity.ok(ResponseDTO.of(dto, "success"));
        }catch(Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ResponseDTO.of("failure"));
        }
    }
    @GetMapping("/author")
    public ResponseEntity<ResponseDTO> getAuthor(@RequestParam("name")String name, @RequestParam("surname")String surname){
        try {
            return ResponseEntity.ok(ResponseDTO.of(new AuthorDTO(authorService.getByName(name, surname)), "success"));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ResponseDTO.of("failure"));
        }
    }
    @PostMapping("/author")
    public ResponseEntity<String> addAuthor(AuthorDTO authorDTO){
        try {
            AuthorEntity author = new AuthorEntity();
            author.setNationalityByCountryId(nationalityService.getByCountry(authorDTO.getCountry()));
            author.setNationalityByNationalityId(nationalityService.getByNationality(authorDTO.getNationality()));
            author.setSurname(authorDTO.getSurname());
            author.setName(authorDTO.getName());
            author.setBirthYear(authorDTO.getBirthYear());
            authorService.addAuthor(author);
            return ResponseEntity.ok("success");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok("error");
        }
    }
    @DeleteMapping("/author")
    public ResponseEntity<String> deleteAuthor(@RequestParam("name") String name, @RequestParam("surname") String surname){
        try{
            authorService.deleteAuthor(name, surname);
            return ResponseEntity.ok("success");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok("failure");
        }
    }
}
