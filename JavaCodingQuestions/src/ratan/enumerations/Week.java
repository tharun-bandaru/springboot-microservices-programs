package ratan.enumerations;

public enum Week {

	MON,TUE(10),WED(10,20);
	Week(int a)
	{
		System.out.println("0-arg const");
	}
	Week(int a,int b)
	{
		System.out.println("2-arg const");
	}
	Week(){
		System.out.println("1-arg const");
	}
	static
	{
		System.out.println("static block");
	}
	{
		System.out.println("instance block");
	}
	public static void main(String[] args) {
		System.out.println("main method");
	}
}
