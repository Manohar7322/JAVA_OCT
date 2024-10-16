package TC;

public class TC_Exception1 {
	public static void main(String[]args) {
		try
		{
			int res=10/1;
			int[] numbers= {1,2,3};
			System.out.println(numbers[5]);
			String text=null;
			System.out.println("length of the string is:"+text.length());
		}
		catch(ArithmeticException e)
		{
			System.out.println("Arithmetic error:"+e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e1)
		{
			System.out.println("Arithmetic error:"+e1.getMessage());
		}
		catch(NullPointerException e2)
		{
			System.out.println("Arithmetic error:"+e2.getMessage());
		}
		catch(Exception e3) {
			System.out.println("unexpected error:"+e3.getMessage());
		}
		finally {
			System.out.println("this is the final block");
		}
	}

}
