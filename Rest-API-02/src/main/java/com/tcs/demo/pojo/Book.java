package com.tcs.demo.pojo;

public class Book {

	private Integer bookId;
	private String title;
	private Double price;
	public Integer getBookId() {
		return bookId;
	}

	public Book() {
		super();
	}
	public Book(Integer bookId, String title, Double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
