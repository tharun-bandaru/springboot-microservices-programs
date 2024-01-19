package com.tcs.page.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="emp")
@Data
public class Employee {

	@Id
	private Integer empno;
	private String ename;
	private Float sal;
	private Integer deptno;
}
