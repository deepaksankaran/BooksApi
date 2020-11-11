package com.BooksApi.serviceTest;



import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.BooksApi.model.BookModel;
import com.BooksApi.repo.BookRepository;
import com.BooksApi.service.BookService;
import com.BooksApi.serviceImpl.BookServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookServiceImpl bookServiceImpl;
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void addBooks() {
		BookModel bookModel=new BookModel();
		bookModel.setAuthor("TEST_Author");
		bookModel.setCategory("TEST_Cat");
		bookModel.setDescription("TEST_description");
		bookModel.setName("test name");
		bookModel.setPrice(455);
		bookModel.setRating(5);
		bookModel.setId(10);
        Mockito.when(bookRepository.save(bookModel)).thenReturn(bookModel);
//        assertThat(bookServiceImpl.addBookService(bookModel)).isEqualTo(bookModel);
		
	}
	

}
