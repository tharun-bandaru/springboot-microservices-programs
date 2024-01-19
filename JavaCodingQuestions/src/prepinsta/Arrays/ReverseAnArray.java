package prepinsta.Arrays;

import java.util.Scanner;


public class ReverseAnArray {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		System.out.println("Enter the elements");
		int s=0;
		int e=a.length-1;
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}

		while(s<e) {
			int temp=a[s];
			a[s]=a[e];
			a[e]=temp;
			s++;e--;
		}
		System.out.println("Reversed Arrays: ");
		for(int aa:a) {
			System.out.print(aa+" ");
		}
		sc.close();
		

	}

}
