package prepinsta.Arrays;

import java.util.Arrays;
import java.util.Scanner;
public class SortHalfAscAndHalfDesc {

	public static void WithoutSortMethod(int a[])
	{
		int n=a.length;
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			for(int j=n/2;j<n-1;j++)
			{
				if(a[j]<a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println("final sorted array ");
		for(int aa: a)
		{
			System.out.print(aa+" ");
		}
	}

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		System.out.println("Enter the elements");

		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		WithoutSortMethod(a);
		Arrays.sort(a,a.length/2,a.length);
		System.out.println("sorted array ");
		for(int aa: a)
		{
			System.out.println(aa);
		}
		sc.close();


	}

}
