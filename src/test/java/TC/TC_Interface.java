package TC;

interface simplecalc{
	int add(int a,int b);
	int i=10;
}

class clac implements simplecalc{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
}
public class TC_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clac obj =new clac();
		System.out.println();
	}

}
