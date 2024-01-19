package com.tcs.LambdaExpressions;


@FunctionalInterface
interface Greetings{
	void greet();
}

public class LambdaWithoutArgs {

	public static void main(String[] args) {
		
		Greetings g1= ()->System.out.println("no args greet implementation");
		g1.greet();
		System.out.println("*****************");
		Greetings g2= ()->{
			System.out.println("no args greet implementation stm-1");
			System.out.println("no args greet implementation stm-2");
		};
		g2.greet();
	}

}
