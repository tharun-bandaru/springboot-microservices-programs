package com.tcs.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
	
	@Id
	private Integer customerId;
	
	private String customerName;
	
	
}
