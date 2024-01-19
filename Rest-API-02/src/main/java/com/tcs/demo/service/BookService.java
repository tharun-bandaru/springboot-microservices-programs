package com.tcs.demo.service;

import com.tcs.demo.pojo.Book;


public interface BookService {

	public boolean addBook(Book book);

	public Book fetchBookById(Integer bookId); 

	public boolean updateBook(Book book);

	public void deleteBook(Integer bookId);

}
