package com.BooksApi.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BooksApi.model.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

}
