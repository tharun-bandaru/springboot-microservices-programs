package com.tcs.app.constants;

public class AppConstants {

	public static final String EMP_INSERT_QUERY="INSERT INTO EMP(EMPNO,ENAME,SAL,DEPTNO) VALUES (?,?,?,?)";
	
	public static final String EMP_SELECT_ONE ="SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
}
