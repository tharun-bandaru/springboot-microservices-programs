package prepinsta.Arrays;

import java.util.Scanner;


public class LargestElementInArray {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		System.out.println("Enter the elements");
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max)
				max=a[i];
		}
		System.out.println("Largest element: "+max);
		sc.close();
		

	}

}
