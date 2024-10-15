package TC;

public class TC0013_overloading {

	TC0013_overloading(){
		System.out.println("cons without parameter");
	}
	
	TC0013_overloading(int value){
		System.out.println("cons with parameter:"+value);
	}
	public static void main(String[] args) {
		TC0013_overloading obj = new TC0013_overloading();
		TC0013_overloading obj1 = new TC0013_overloading(5000);
		System.out.println();
		

	}

}
