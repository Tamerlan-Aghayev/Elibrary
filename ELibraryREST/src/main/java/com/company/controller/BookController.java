package com.company.controller;

import com.company.dto.AuthorDTO;
import com.company.dto.BookDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.BookEntity;
import com.company.service.AuthorService;
import com.company.service.BookService;
import com.company.service.LibraryService;
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
    private AuthorService authorService;
    @Autowired
    private LibraryService libraryService;
    private ResponseDTO response=new ResponseDTO();
    @GetMapping("/books")
    public ResponseEntity<ResponseDTO> getBooks(){

        try{
            List<BookEntity> list=bookService.getAll();
            List<BookDTO> dto=new ArrayList<>();
            for(BookEntity b: list){
                dto.add(new BookDTO(b));
            }
            response=ResponseDTO.of(dto, "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/book/{name}")
    public ResponseEntity<ResponseDTO> getBookByName(@PathVariable("name") String name){

        try{
            response=ResponseDTO.of(new BookDTO(bookService.getByName(name)), "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/book")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookDTO book){

        try{
            BookEntity result=new BookEntity();
            result.setId(book.getId());
            result.setName(book.getName());
            result.setAuthorByAuthorId(authorService.getByName(book.getAuthorName(), book.getAuthorSurname()));
            result.setLibraryByLibraryId(libraryService.getByName(book.getLibraryName()));
            bookService.addBook(result);
            response=ResponseDTO.of( "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/book")
    public ResponseEntity<ResponseDTO> deleteBook(@RequestParam("name") String name){

        try{
            bookService.deleteBook(name);
            response=ResponseDTO.of( "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }

}
