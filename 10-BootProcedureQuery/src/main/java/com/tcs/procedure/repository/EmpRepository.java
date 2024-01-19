package com.tcs.procedure.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.tcs.procedure.entity.EmpEntity;

public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {

	@Procedure(name="pro1")
	Map<String,Object> getData(Integer p1);
}
