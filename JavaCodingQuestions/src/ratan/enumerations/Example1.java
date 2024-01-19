package ratan.enumerations;

public class Example1 {

	enum Mail{
		INBOX,SENT,DELTE;
		Mail(){
			System.out.println("Mail constructor");
		}
	}

	public static void main(String[] args) {

		Mail[] mm=Mail.values();
		System.out.println("************");
		for(Mail m:mm)
		{
			System.out.println(m.ordinal());
		}

		Mail m1=Mail.INBOX;
		System.out.println(m1);
	}

}
