package prepinsta.Arrays;

import java.util.Scanner;


public class SumOfElementInArray {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		System.out.println("Enter the elements");
		int sum=0;
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
			sum+=a[i];
		}
		System.out.println("sum of elements"+sum);
		sc.close();
		

	}

}
