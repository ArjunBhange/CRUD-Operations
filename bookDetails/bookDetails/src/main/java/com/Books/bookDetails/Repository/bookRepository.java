package com.Books.bookDetails.Repository;


import com.Books.bookDetails.Entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepository extends JpaRepository<book,Long> {

}
