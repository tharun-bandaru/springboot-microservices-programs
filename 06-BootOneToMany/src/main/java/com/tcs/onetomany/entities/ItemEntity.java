package com.tcs.onetomany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_item")
@Data
public class ItemEntity {
	
	@Id
	private Integer item_id;
	private String item_name;

}
