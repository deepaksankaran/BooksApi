package com.BooksApi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BooksApi.model.BookModel;
import com.BooksApi.repo.BookRepository;
import com.BooksApi.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;

	@PostMapping("/add")
	public BookModel save(@RequestBody BookModel bookModel) {

		return bookRepository.save(bookModel);
	}

	@GetMapping(produces = "application/json")
	public List<BookModel> listall() {
		return bookService.getBooksList();

	}

	@GetMapping("/{id}")
	public ResponseEntity<BookModel> getBookById(@PathVariable("id") Long id) {
		try {
			BookModel bookModel = bookService.getBooksById(id);
			return new ResponseEntity<>(bookModel, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
