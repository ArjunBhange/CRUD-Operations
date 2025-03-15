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
    public ResponseEntity<List<book>> getbook(@PathVariable long id){
        Optional<book> book2=bookrepo.findById(id);
        if(book2.isPresent()){
            return new ResponseEntity<>(new ArrayList<book>(book2),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
