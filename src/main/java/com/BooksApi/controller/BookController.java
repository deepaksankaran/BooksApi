package com.BooksApi.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BooksApi.model.BookModel;
import com.BooksApi.repo.BookRepository;
import com.BooksApi.service.BookService;

/**
 * @author dpzz
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;
	
//	
//	@PostMapping("/add")
//	public BookModel save(@RequestBody BookModel bookModel) {
//    
//		bookModel.setName(bookModel.getName());
//		bookModel.setAuthor(bookModel.getAuthor());
//		bookModel.setDescription(bookModel.getDescription());
//		bookModel.setPrice(bookModel.getPrice());
//		bookModel.setCategory(bookModel.getCategory());
//		bookModel.setRating(bookModel.getRating());
////		 System.out.println("added"+bookRepository.save(bookModel));
//		return bookRepository.save(bookModel);
//	}


	@GetMapping("/list")
	public List<BookModel> listall(Authentication auth) {
		//System.out.println("booklist"+bookService.getBooksList());
		return bookService.getBooksList();

	}

	/**
	 * @param id
	 * @return
	 */
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
	
	
	@GetMapping("/categoryList")
	public ResponseEntity<List<String>> categoryList(Authentication auth){
		
		return new ResponseEntity<List<String>>(bookService.getCategoryList(),HttpStatus.OK);
		
	}
	
//	@GetMapping("/{id}")
//	public BookModel getBookById(@PathVariable int id ,Authentication auth){
//		System.out.println("idis"+bookService.getBooksById(id));
//		return bookService.getBooksById(id);
//		
//	}
	
	
	@PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
//	public BookModel save(@RequestBody BookModel bookModel) {
		public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {   
		bookModel.setName(bookModel.getName());
		bookModel.setAuthor(bookModel.getAuthor());
		bookModel.setDescription(bookModel.getDescription());
		bookModel.setPrice(bookModel.getPrice());
		bookModel.setCategory(bookModel.getCategory());
		bookModel.setRating(bookModel.getRating());
		bookService.addBookService(bookModel);
//		 System.out.println("added"+bookRepository.save(bookModel));
		//Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(bookModel.getId())
                                    .toUri();
		return ResponseEntity.created(location).build();
	}
//	@GetMapping("/{name}")
//	public List<BookModel> getBookByName(@PathVariable String name ){
////		System.out.println("idis"+bookService.getBooksById(id));
//		return (List<BookModel>) bookService.getBooksByName(name);
//		
//	}
	
	
	
//	@GetMapping("/accounts/dashboard/{bankName}")
//	public ResponseEntity<AccountModel> getBankDetails(@PathVariable("bankName") String bankName) {
//		logger.info("Entered: Method: getBankDetails, Class: AccountsController");
//		logger.debug("Bank Name: ", bankName);
//		AccountModel accounts = accountsService.findByBankName(bankName);
//		logger.info("Exited: Method: getBankDetails, Class: AccountsController");
//		return new ResponseEntity<>(accounts, HttpStatus.OK);
//	}
}
