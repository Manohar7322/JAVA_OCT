package TC;

public class tc01_balance {
	
	String name;
	double bal;
	
	public tc01_balance(String n ,double b)
	{
		name = n;
		bal = b;
		
	}
	
	public void show()
	{
		if(bal>0)
		{
			System.out.println("Balance of"+name+"is"+"$"+bal);
		}
	}

}
