package prepinsta.Arrays;

import java.util.Scanner;


public class LargestAndSmallestElementInArray {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		System.out.println("Enter the elements");
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		int max=a[0];
		int min=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max)
				max=a[i];
			if(a[i]<min)
				min=a[i];
		}
		System.out.println("Largest element: "+max);
		System.out.println("Smallest element: "+min);
		sc.close();
		

	}

}
