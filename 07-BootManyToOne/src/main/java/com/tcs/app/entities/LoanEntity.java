package com.tcs.app.entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {

	@Id
	private Integer loanId;

	private String loanType;

	private Double amount;

	/*
	 * multiple loan entites to single customer entity i.e many to one
	 * 
	 * By default manytoone fetchType is eager
	 */
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")	
	private CustomerEntity customerEntity;


}
