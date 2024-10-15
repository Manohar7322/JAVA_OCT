package Lab_2;
import java.util.Scanner;

public class Acc_main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name for first account holder:");
        String name1 = sc.nextLine();
        System.out.println("Enter age for " + name1 + ":");
        float age1 = sc.nextFloat();
        sc.nextLine();

        System.out.println("Enter initial balance for " + name1 + ":");
        double initialBalance1 = sc.nextDouble();
        sc.nextLine(); 
        Person accHolder1 = new Person(name1, age1);

        System.out.println("Enter name for second account holder:");
        String name2 = sc.nextLine();
        System.out.println("Enter age for " + name2 + ":");
        float age2 = sc.nextFloat();
        sc.nextLine(); 

        System.out.println("Enter initial balance for " + name2 + ":");
        double initialBalance2 = sc.nextDouble();
        Person accHolder2 = new Person(name2, age2);

        
        SavingsAccount savingsAccount = new SavingsAccount(initialBalance1, accHolder1);
        CurrentAccount currentAccount = new CurrentAccount(initialBalance2, accHolder2);

        System.out.println("Initial details:");
        System.out.println(savingsAccount);
        System.out.println(currentAccount);

        System.out.println("\nEnter amount to deposit in " + name1 + "'s Savings Account:");
        double deposit1 = sc.nextDouble();
        savingsAccount.deposit(deposit1);

        System.out.println("Enter amount to deposit in " + name2 + "'s Current Account:");
        double deposit2 = sc.nextDouble();
        currentAccount.deposit(deposit2);

        System.out.println("\nEnter amount to withdraw from " + name1 + "'s Savings Account:");
        double withdraw1 = sc.nextDouble();
        savingsAccount.withdraw(withdraw1);

        System.out.println("Enter amount to withdraw from " + name2 + "'s Current Account:");
        double withdraw2 = sc.nextDouble();
        currentAccount.withdraw(withdraw2);

        System.out.println("\nUpdated details:");
        System.out.println(savingsAccount);
        System.out.println(currentAccount);

        sc.close();
    }
}



