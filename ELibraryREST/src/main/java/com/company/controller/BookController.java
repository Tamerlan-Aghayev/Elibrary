package com.company.controller;

import com.company.dto.BookDTO;
import com.company.dto.LibraryDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;
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
    private LibraryService libraryService;
    private ResponseDTO response=new ResponseDTO();
    @GetMapping("/books")
    public ResponseEntity<ResponseDTO> getBooks(@RequestBody LibraryEntity library){
        List<BookEntity> bookEntities=library.getBooksById();
        List<BookDTO> dtos=new ArrayList<>();
        for(BookEntity book:bookEntities){
            dtos.add(new BookDTO(book));
        }
        return ResponseEntity.ok(ResponseDTO.of(dtos, "success"));
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
    @GetMapping("/book")
    public ResponseEntity<ResponseDTO> getBookByNameByLibrary(@RequestParam("name") String name, @RequestBody LibraryEntity library){

        try{
            response=ResponseDTO.of(new BookDTO(bookService.getByNameByLibrary(name, library)), "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/book")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookDTO book, @RequestBody LibraryDTO dto){

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

    @DeleteMapping("/book")
    public ResponseEntity<ResponseDTO> deleteBook(@RequestParam("name") String name, @RequestBody LibraryEntity library){

        try{
            bookService.deleteBook(name,library );
            response=ResponseDTO.of( "successful");
        }catch (Exception ex){
            ex.printStackTrace();
            response=ResponseDTO.of("error occurred");
        }
        return ResponseEntity.ok(response);
    }

}
