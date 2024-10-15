package Lab_1;

import java.util.*;


public class Personmain {

	private String FirstName;
	private String LastName;
	private Gen Gender;
	private long phoneNo;
	
	static enum Gen{
		M,F;
	}
	
	public long getPhoneNo() {
		return phoneNo;
	}
 
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
 
	private void setFirstName(String FirstName) {
		this.FirstName=FirstName;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	private void setLastName(String LastName) {
		this.LastName=LastName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	private void setGender(Gen Gender) {
		this.Gender=Gender;
	}
	
	public Gen getGender() {
		return Gender;
	}
	
	public void display(String FirstName,String LastName,Gen Gender,long Phone) {
		System.out.print("FirstName:"+FirstName+'\n'+"LastName:"+LastName+'\n'+"Gender:"+Gender+'\n'+"Phone:"+Phone);
	}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
//	System.out.println("Enter the FirstName");
	Personmain person=new Personmain();
	String fname=sc.nextLine();
//	System.out.println("Enter the LastName");
	String lname=sc.nextLine();
//	char g=sc.next().charAt(0);
	long ph=sc.nextLong();
	person.setFirstName("swetha");
	String FirstName=person.getFirstName();
	person.setLastName("yanala");
	String LastName=person.getLastName();
	person.setGender(Personmain.Gen.F);
	Gen Gender=person.getGender();
	person.setPhoneNo(ph);
	long Phone=person.getPhoneNo();
	person.display(FirstName,LastName,Gender,Phone);
}

}
