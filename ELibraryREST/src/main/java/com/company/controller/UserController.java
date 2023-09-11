package com.company.controller;

import com.company.data.UserLibraryData;
import com.company.dto.LibraryDTO;
import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import com.company.service.LibraryService;
import com.company.service.UserLibraryService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private UserLibraryService userLibraryService;
    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(@RequestBody LibraryDTO libraryDTO) {
        LibraryEntity library=libraryService.getByName(libraryDTO.getName());

        List<UserEntity> list = userService.getALL(library);
        List<UserDTO> dto = new ArrayList<>();
        for (UserEntity u : list) {
            dto.add(new UserDTO(u));
        }

        return ResponseEntity.ok(ResponseDTO.of(dto));

    }
    @GetMapping("/user")
    public ResponseEntity<ResponseDTO> getUser(@RequestParam("name") String name, @RequestParam("surname")String surname ,@RequestBody LibraryDTO libraryDTO) {
        LibraryEntity library = libraryService.getByName(libraryDTO.getName());

        UserEntity user = userService.getUser(name, surname, library);
        UserDTO dto = new UserDTO(user);

        return ResponseEntity.ok(ResponseDTO.of(dto));
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserLibraryData userLibraryData){
        LibraryDTO libraryDTO=userLibraryData.library;
        UserDTO userDTO=userLibraryData.user;
        LibraryEntity library = libraryService.getByName(libraryDTO.getName());
        userService.addUser(userDTO.getName(),userDTO.getSurname(), userDTO.getUsername(), userDTO.getFin(), userDTO.getAddress(), library);


        return ResponseEntity.ok(ResponseDTO.of("success"));
    }
    @PostMapping("/registration")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserDTO userDTO, @RequestParam("password") String password){

        userService.registerUser(new UserEntity(userDTO.getName(),userDTO.getSurname(), userDTO.getFin(),userDTO.getUsername(), userDTO.getAddress()), password);


        return ResponseEntity.ok(ResponseDTO.of("success"));
    }

    @DeleteMapping("/user")
    public ResponseEntity<ResponseDTO> deleteUser(@RequestParam("name") String name, @RequestParam("surname") String surname,@RequestBody LibraryDTO libraryDTO){
        LibraryEntity library = libraryService.getByName(libraryDTO.getName());
        UserEntity userEntity=userService.getUser(name, surname, library);
        userLibraryService.delete(userEntity, library);
        return ResponseEntity.ok(ResponseDTO.of("success"));
    }


}
