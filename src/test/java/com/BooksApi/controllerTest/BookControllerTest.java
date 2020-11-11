package com.BooksApi.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import com.BooksApi.controller.BookController;
import com.BooksApi.model.BookModel;
import com.BooksApi.repo.BookRepository;
import com.BooksApi.service.BookService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class BookControllerTest {

	@InjectMocks
	BookController bookController;
	@Mock
	BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
	@Test
	public void testBooks() throws Exception {

        BookModel mockBookModel = new BookModel();
		mockBookModel.setAuthor("TEST_Author");
		mockBookModel.setCategory("TEST_Cat");
		mockBookModel.setDescription("TEST_description");
		mockBookModel.setName("test name");
		mockBookModel.setPrice(455);
		mockBookModel.setRating(5);
		
		verify(bookService,times(1)).addBookService(mockBookModel);
		bookService.addBookService(mockBookModel);
	}

}
