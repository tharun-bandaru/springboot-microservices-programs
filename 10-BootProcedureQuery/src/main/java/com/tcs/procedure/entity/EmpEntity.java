package com.tcs.procedure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="EMP")
@Data
@NamedStoredProcedureQuery(
		name="pro1",
		procedureName="BONUSPRO",
		parameters= {
				@StoredProcedureParameter(mode=ParameterMode.IN,type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.OUT,type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.OUT,type=Double.class)
		}
		)

public class EmpEntity {

	@Id
	private Integer empno;
	private String ename;
	private Double sal;
	private Integer deptno;
}
