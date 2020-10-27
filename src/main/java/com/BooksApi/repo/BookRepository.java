package com.BooksApi.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BooksApi.model.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
	
	@Query(value = "select category from book", nativeQuery = true)
	List<String> categoryList();

}
