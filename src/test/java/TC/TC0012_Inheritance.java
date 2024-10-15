package TC;

class Base{
	public void basemethod() {
		System.out.println("this is method from base class");
	}
}
class Derived {
	public void derivedmethod() {
		System.out.println("this is method from derived class");
	}
}

public class TC0012_Inheritance {

	public static void main(String[] args) {
		
		Derived obj=new Derived();
		obj.derivedmethod();
		

	}

}
