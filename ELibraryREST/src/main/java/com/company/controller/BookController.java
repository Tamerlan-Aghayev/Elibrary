package com.company.controller;

import com.company.data.BookLibraryData;
import com.company.data.UserLibraryData;
import com.company.dto.BookDTO;
import com.company.dto.LibraryDTO;
import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import com.company.service.BookService;
import com.company.service.LibraryService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @Autowired
    private LibraryService libraryService;
    private ResponseDTO response=new ResponseDTO();
    @GetMapping("/books")
    public ResponseEntity<ResponseDTO> getBooks(@RequestBody LibraryDTO library){
        List<BookEntity> bookEntities=libraryService.getByName(library.getName()).getBooksById();
        List<BookDTO> dtos=new ArrayList<>();
        for(BookEntity book:bookEntities){
            dtos.add(new BookDTO(book));
        }
        return ResponseEntity.ok(ResponseDTO.of(dtos, "success"));
    }

    @GetMapping("/book")
    public ResponseEntity<ResponseDTO> getBookByName(@RequestParam("name") String name, @RequestBody LibraryDTO dto){

        try{
            response=ResponseDTO.of(new BookDTO(bookService.getByNameByLibrary(name, libraryService.getByName(dto.getName()))), "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping("/book")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookLibraryData bookLibraryData){
        BookDTO book=bookLibraryData.book;
        LibraryDTO dto=bookLibraryData.library;
        try{
            BookEntity result=new BookEntity();
            result.setName(book.getName());
            result.setAuthor(book.getAuthor());

            LibraryEntity library=libraryService.getByName(dto.getName());


            bookService.addBook(result,library );
            response=ResponseDTO.of( "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/book_available")
    public ResponseEntity<ResponseDTO> makeAvailable(@RequestParam("name") String name, @RequestBody LibraryDTO libraryDTO){

        try{

            LibraryEntity library=libraryService.getByName(libraryDTO.getName());
            bookService.setAvailable(name, library);
            response=ResponseDTO.of( "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping("/book_unavailable")
    public ResponseEntity<ResponseDTO> makeUnavailable(@RequestParam("name") String name, @RequestBody UserLibraryData userLibraryData){
        UserDTO userDTO=userLibraryData.user;
        LibraryDTO libraryDTO=userLibraryData.library;
        try{
            UserEntity user=userService.getUserByUsername(userDTO.getUsername());
            LibraryEntity library=libraryService.getByName(libraryDTO.getName());
            bookService.setUnavailable(user, "name", library);
            response=ResponseDTO.of( "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/book")
    public ResponseEntity<ResponseDTO> deleteBook(@RequestParam("name") String name, @RequestBody LibraryDTO library){

        try{
            bookService.deleteBook(name,libraryService.getByName(library.getName()) );
            response=ResponseDTO.of( "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }

}
