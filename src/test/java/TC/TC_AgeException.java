package TC;

import java.util.Scanner;

class ageexception extends Exception {
    private int age;

    ageexception(int a) {
        age = a;
    }

    public String toString() {
        return age + " is an invalid age";
    }
}

class employee {
    String name;
    int age;

    void getdetails() throws ageexception {
        System.out.println("Enter your name");
        Scanner sc = new Scanner(System.in);
        name = sc.next();

        System.out.println("Enter your age");
        age = sc.nextInt();
        if (age < 16) {
            throw new ageexception(age);
        }
    }
}

public class TC_AgeException {
    public static void main(String[] args) {
        try {
            employee emp = new employee();
            emp.getdetails();
        } catch (ageexception e) {
            System.out.println("Age Exception: " + e.getMessage());
        }
    }
}
