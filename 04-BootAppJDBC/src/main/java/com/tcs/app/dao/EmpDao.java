package com.tcs.app.dao;

import java.util.Map;

public interface EmpDao {
	
	void saveEmployee(int eno,String ename,double sal, int deptno);
	Map<String,Object> fetchEmployeeById(int empno);

}
