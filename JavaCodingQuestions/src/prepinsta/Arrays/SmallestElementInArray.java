package prepinsta.Arrays;

import java.util.Scanner;


public class SmallestElementInArray {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		System.out.println("Enter the elements");
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<min)
				min=a[i];
		}
		int secMin=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=min && a[i]<secMin)
			{
				secMin=a[i];
			}
		}
		System.out.println("Smallest element: "+min);
		System.out.println("Second Smallest element: "+secMin+" ");
		sc.close();
		

	}

}
