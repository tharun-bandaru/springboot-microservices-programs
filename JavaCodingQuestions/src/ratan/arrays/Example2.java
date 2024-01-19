package ratan.arrays;

class Employee{
	int eid;
	String name;
	public Employee(int eid,String name) {
		this.eid=eid;
		this.name=name;
	}
}
public class Example2 {
	public static void main(String[] args) {

		Employee[] e=new Employee[3];
		Employee e1=new Employee(1,"tharun");
		Employee e2=new Employee(2,"ram");
		e[0]=e1;e[1]=e2;
		for(Employee ee:e)
		{
			if(ee instanceof Employee) {
				System.out.println(ee.eid+" "+ee.name);
			}
			if(ee==null)
			{
				System.out.println(ee);
			}
		}

	}

}
