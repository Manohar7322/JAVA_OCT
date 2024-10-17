package Lab_1;

import java.util.*;

public class Personmain {

    private String FirstName;
    private String LastName;
    private Gen Gender;
    private long phoneNo;
    static enum Gen {
        M, F;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    private void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }
    private void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getLastName() {
        return LastName;
    }
    private void setGender(Gen Gender) {
        this.Gender = Gender;
    }
    public Gen getGender() {
        return Gender;
    }
    public void display() {
        System.out.println("FirstName: " + FirstName);
        System.out.println("LastName: " + LastName);
        System.out.println("Gender: " + Gender);
        System.out.println("Phone: " + phoneNo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personmain person = new Personmain();
        System.out.print("Enter First Name: ");
        String fname = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lname = sc.nextLine();
        System.out.print("Enter Gender (M/F): ");
        String genderInput = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        long ph = sc.nextLong();
        person.setFirstName(fname);
        person.setLastName(lname);
        if (genderInput.equalsIgnoreCase("M")) {
            person.setGender(Personmain.Gen.M);
        } else if (genderInput.equalsIgnoreCase("F")) {
            person.setGender(Personmain.Gen.F);
        } else {
            System.out.println("Invalid Gender. Defaulting to Male (M).");
            person.setGender(Personmain.Gen.M); 
        }
        person.setPhoneNo(ph);
        person.display();
        sc.close();
    }
}
