package com.Books.bookDetails.Controller;

import com.Books.bookDetails.Entity.book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class Bookcontroller {

    @PostMapping("/book")
    public void saveBook(@RequestBody  book book){
    System.out.println("hi your work has succeed");
    }

}
