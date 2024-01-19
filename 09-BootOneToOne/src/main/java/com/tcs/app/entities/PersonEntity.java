package com.tcs.app.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_person")
@Data
public class PersonEntity {

	@Id
	private Integer pid;
	private String pname;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="passportno",unique=true,nullable=false)
	private PassportEntiy p;
}
