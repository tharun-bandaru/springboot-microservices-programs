package com.tcs.LambdaExpressions;


@FunctionalInterface
interface Login{
	String check(String username, String password);
}

public class LambdaWithReturnType {

	public static void main(String[] args) {

		Login l1= (username,password) -> {
			return username.equalsIgnoreCase("Tharun") && password.equals("tharun@123") ?
					"Login Success" : "Login Fail";
		};

		String res= l1.check("tharun","tharun@123");
		System.out.println(res);
	}


}

