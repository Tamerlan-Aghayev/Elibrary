package com.company.controller;

import com.company.dto.NationalityDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.NationalityEntity;
import com.company.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NationalityController {
    @Autowired
    private NationalityService nationalityService;
    private ResponseDTO response=new ResponseDTO();
    @GetMapping("/nationalities")
    public ResponseEntity<ResponseDTO> getNationalities(){
        try {
            List<NationalityEntity> list = nationalityService.getAll();
            List<NationalityDTO> dto = new ArrayList<>();
            for (NationalityEntity n : list) {
                dto.add(new NationalityDTO(n));

            }
            response=ResponseDTO.of(dto, "success");
        }
        catch(Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of( "failure");
        }


        return ResponseEntity.ok(response);
    }
    @GetMapping("/nationality")
    public ResponseEntity<ResponseDTO> getNationality(@RequestParam("name")String name){
        try {

            NationalityEntity n=nationalityService.getByCountry(name);
            return ResponseEntity.ok(ResponseDTO.of(new NationalityDTO(n), "success"));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ResponseDTO.of("eror"));
        }
    }
    @PostMapping("/nationality")
    public void addNationality(NationalityDTO nationalityDTO){
        try {
            NationalityEntity nationality = new NationalityEntity();
            nationality.setNationality(nationalityDTO.getNationality());
            nationality.setCountry(nationalityDTO.getCountry());
            nationalityService.addNationality(nationality);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @DeleteMapping("/nationality")
    public void deleteNationality(String name){
        try {
            nationalityService.deleteNationality(name);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
