package com.tcs.LambdaExpressions;


@FunctionalInterface
interface Operations{
	void add(int a, int b);
}

public class LambdaWithArgs {

	public static void main(String[] args) {
		
		Operations op1=(int a, int b)-> System.out.println("Addition of 2 nums "+(a+b));
		op1.add(10,20);
		
		Operations op2=(a,b)-> System.out.println("Addition of 2 nums "+(a+b));
		op2.add(100,200);
	}

}
