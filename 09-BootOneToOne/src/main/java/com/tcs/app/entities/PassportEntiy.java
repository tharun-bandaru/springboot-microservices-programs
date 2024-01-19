package com.tcs.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_passport")
@Data
public class PassportEntiy {

	@Id
	private Integer passportNo;
	private LocalDate expdate;
	
}
