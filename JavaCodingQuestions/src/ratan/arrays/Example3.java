package ratan.arrays;


class Employe{
	int eid;
	String ename;
	public Employe(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
}

class Student{
	int sid;
	String sname;
	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
}

public class Example3 {

	public static void main(String[] args) {

		Object[] o=new Object[5];
		o[0]=new Employe(1,"tharun");
		o[1]=new Student(2,"student");
		o[2]=new String("Shiva");
		for(Object oo:o)
		{
			if(oo instanceof Employe) {
				Employe e1=(Employe)oo;
				System.out.println(e1.eid+" "+e1.ename);
			}
			if(oo instanceof Student) {

				Student s1=(Student)oo;
				System.out.println(s1.sid+" "+s1.sname);
			}
			System.out.println(oo);


		}




	}

}
