package Lab_3;

import java.util.Scanner;

class NameEmptyException extends Exception {
    public NameEmptyException(String message) {
        super(message);
    }
}
public class personmain_1 {
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
    public void setFirstName(String FirstName) throws NameEmptyException {
        if (FirstName == null || FirstName.trim().isEmpty()) {
            throw new NameEmptyException("First Name cannot be blank");
        }
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }
    public void setLastName(String LastName) throws NameEmptyException {
        if (LastName == null || LastName.trim().isEmpty()) {
            throw new NameEmptyException("Last Name cannot be blank");
        }
        this.LastName = LastName;
    }

    public String getLastName() {
        return LastName;
    }
    public void setGender(Gen Gender) {
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
        personmain_1 person = new personmain_1();

        try {
            System.out.print("Enter First Name: ");
            String fname = sc.nextLine();
            System.out.print("Enter Last Name: ");
            String lname = sc.nextLine();

            person.setFirstName(fname);
            person.setLastName(lname);

            System.out.print("Enter Gender (M/F): ");
            String genderInput = sc.nextLine();
            if (genderInput.equalsIgnoreCase("M")) {
                person.setGender(personmain_1.Gen.M);
            } else if (genderInput.equalsIgnoreCase("F")) {
                person.setGender(personmain_1.Gen.F);
            } else {
                System.out.println("Invalid Gender. Defaulting to Male (M).");
                person.setGender(personmain_1.Gen.M); 
            }
            System.out.print("Enter Phone Number: ");
            long ph = sc.nextLong();
            person.setPhoneNo(ph);

            person.display();

        } catch (NameEmptyException e) {
            
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

}
