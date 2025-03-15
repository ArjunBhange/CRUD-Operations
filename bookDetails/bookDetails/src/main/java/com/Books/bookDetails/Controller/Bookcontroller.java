package com.Books.bookDetails.Controller;

import com.Books.bookDetails.Entity.book;
import com.Books.bookDetails.Repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")

public class Bookcontroller {
    @Autowired
    bookRepository bookrepo;

    @PostMapping("/book")
    public ResponseEntity<book> saveBook(@RequestBody book book){
       return new ResponseEntity<>(bookrepo.save(book),HttpStatus.CREATED);
    }
    @GetMapping("/book")
    public ResponseEntity<List<book>> getbooks(){
        return new ResponseEntity<>(bookrepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<book> getbook(@PathVariable long id){
        Optional<book> book2=bookrepo.findById(id);
        if(book2.isPresent()){
            return new ResponseEntity<>(book2.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<book> setbook(@PathVariable long id,@RequestBody book book3){
        Optional<book> book2=bookrepo.findById(id);
        if(book2.isPresent()){
            book2.get().setAuthor(book3.getAuthor());
            book2.get().setTitle(book3.getTitle());
            book2.get().setTitle(book3.getAvailable());
            book2.get().setTitle(book3.getCategory());

            return new ResponseEntity<>(bookrepo.save(book2.get()),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
