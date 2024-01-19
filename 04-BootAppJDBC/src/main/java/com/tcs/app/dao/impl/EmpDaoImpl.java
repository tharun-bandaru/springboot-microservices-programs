package com.tcs.app.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.app.constants.AppConstants;
import com.tcs.app.dao.EmpDao;

@Repository
public class EmpDaoImpl implements EmpDao {


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveEmployee(int eno, String ename, double sal, int deptno) {

		System.out.println("employee method");
		try {
			
			/*
			 * update(): is used to perform insert/update/delete operations
			 */
			jdbcTemplate.update(AppConstants.EMP_INSERT_QUERY,eno,ename,sal,deptno);
			System.out.println("Data is saved to database");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	@Override
	public Map<String, Object> fetchEmployeeById(int eno) {

		/*
		 * queryMap() : selects only single record
		 * 				returns a map which contains column names as keys and column values of record
		 * 				as values
		 */

		return jdbcTemplate.queryForMap(AppConstants.EMP_SELECT_ONE, eno);

	}

}
