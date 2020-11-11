package com.BooksApi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.BooksApi.model.BookModel;

@Transactional
@Service(value="bookService")
public interface BookService {
	
	void addBookService(BookModel bookModel);
	
	List<BookModel>getBooksList();
	
	public BookModel getBooksById(Long id);
	
	List<String> getCategoryList();
	
	List<BookModel> listAll(String keyword);

	BookModel findByBookName(String name);
	
}
