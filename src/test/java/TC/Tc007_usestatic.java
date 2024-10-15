package TC;

public class Tc007_usestatic {
	
	static int num1=3;
	static int num2;
	final int a=20;
	static int b=30;
	
	{
		
		System.out.println("static block");
		 num2=num1*4;
		 
	}
	
  static void mymethod(int num3)
  {

		
		System.out.println("Number1:"+num1);
		System.out.println("Number1:"+num2);
		System.out.println("Number1:"+num3);
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int a=20;
		
		mymethod(500);
		
		
		

	}

}
