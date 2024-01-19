package com.tcs.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
	
	@Id
	private Integer authorId;
	
	private String authorName;
	
}
