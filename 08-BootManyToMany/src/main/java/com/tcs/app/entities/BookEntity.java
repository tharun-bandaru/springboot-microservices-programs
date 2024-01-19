package com.tcs.app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
	
	@Id
	private Integer bookId;
	
	private String bookName;
	
	/*
	 * tbl_book_author: name of the join table
	 * joinColumns = @JoinColumn(name="book_id"):
	 *                      fk in join table represents the pk in the source table(i.e tbl_book)
	 * inverseJoinColumns = @JoinColumn(name="author_id")):
	 *                   fk in join table represents the pk in the target table(i.e tbl_author)
	 */
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tbl_book_author",
	joinColumns = @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private List<AuthorEntity> authorsList;

	
}
