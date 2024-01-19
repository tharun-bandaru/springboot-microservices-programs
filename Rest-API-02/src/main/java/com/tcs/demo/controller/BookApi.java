package com.tcs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.demo.pojo.Book;
import com.tcs.demo.service.BookService;

@RestController
@RequestMapping("/book/api")
public class BookApi {

	@Autowired
	BookService bookService;

	@PostMapping("/add")
	public ResponseEntity<String> addBook(@RequestBody Book book)
	{
		if(bookService.addBook(book))
		{
			return new ResponseEntity<String>("Book is added: ",HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.ok("Book doesn't exist");
		}
	}
	
	@GetMapping("fetch/{id}")
	public ResponseEntity<Book> fetchBookById(@PathVariable("id") Integer bookId){
		
		return ResponseEntity.ok(bookService.fetchBookById(bookId));
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		if(bookService.updateBook(book))
		{
			return new ResponseEntity<String>("Book is Updated: ",HttpStatus.ACCEPTED);
		}
		else {
			return ResponseEntity.ok("Book is not updated");
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Integer bookId)
	{
		try {
			bookService.deleteBook(bookId);
			return ResponseEntity.ok("Book is deleted");
		} catch (Exception e) {
			
			return new ResponseEntity<>("Book is doesn't exist",HttpStatus.BAD_REQUEST);
		}
			
		
	}
	

}
