package TC;

public class TC_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try
{
	String str=null;
	str.equals("hello");
}
catch(NullPointerException e)
{
	System.out.println(e.getMessage());
	System.out.println(e.toString());
}
System.out.println("hello");
System.out.println("welcome");

try {
	int a=0;
	int b=30/a;	
}
catch(ArithmeticException e1) {
	System.out.println(e1.getMessage());
	System.out.println(e1.toString());
}
System.out.println("hello1");
System.out.println("welcome1");
	}

}
