package com.tcs.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tcs.demo.pojo.Book;
import com.tcs.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	Map<Integer,Book> bookMap=new HashMap<>();

	@Override
	public boolean addBook(Book book) {

		if(!bookMap.containsKey(book.getBookId())) {
			bookMap.put(book.getBookId(), book);
			return true;
		}
		return false;
	}

	@Override
	public Book fetchBookById(Integer bookId) {

		if(bookMap.containsKey(bookId)) {
			return bookMap.get(bookId);
		}
		return null;
	}

	@Override
	public boolean updateBook(Book book) {
		if(bookMap.containsKey(book.getBookId())) {
			bookMap.put(book.getBookId(), book);
			return true;
		}
		return false;
	}

	@Override
	public void deleteBook(Integer bookId) {
		if(bookMap.containsKey(bookId)) {
			bookMap.remove(bookId);	
		}
		else {
			throw new RuntimeException("Book Id: "+bookId + "id doesn't exist ");
		}

	}

}
