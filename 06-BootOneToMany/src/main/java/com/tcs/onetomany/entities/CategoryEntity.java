package com.tcs.onetomany.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="tbl_category")
@Data
public class CategoryEntity {

	@Id
	private Integer categoryId;
	
	private String categoryName;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private List<ItemEntity> itemCollection;
	
	
	
	
}
