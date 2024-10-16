package Lab_2;

public class ACC_cls {
	abstract static class Account {
	    private long accNum;
	    private double balance;
	    private Person accHolder;
	    private static long accountNumberCounter = 1000; 
	    public Account(double initialBalance, Person accHolder) {
	        this.accNum = ++accountNumberCounter;
	        this.balance = initialBalance;
	        this.accHolder = accHolder;
	    }
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited " + amount + ". New balance: " + balance);
	        }
	    }

	    public abstract boolean withdraw(double amount);

	    public double getBalance() {
	        return balance;
	    }

	    public long getAccNum() {
	        return accNum;
	    }

	    public Person getAccHolder() {
	        return accHolder;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }
	    @Override
	    public String toString() {
	        return "Account{accNum=" + accNum + ", balance=" + balance + ", accHolder=" + accHolder + "}";
	    }
	}

}
