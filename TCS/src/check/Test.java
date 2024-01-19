package check;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        
    	Scanner sc=new Scanner(System.in);
        HashMap<Integer,Double> map = new HashMap<>();
        map.put(1010, 8.4);
        map.put(100, 4.1);
        int n=map.size();
		/*
		 * for(int i=0;i<n;i++) { int e=sc.nextInt(); Integer eid=Integer.valueOf(e);
		 * Double rat=sc.nextDouble(); map.put(eid, rat); }
		 */
     
        for(int i=0;i<map.size();i++)
        {
        	System.out.println(map+" "+map.get(map));
        }
        

     
    }
}
