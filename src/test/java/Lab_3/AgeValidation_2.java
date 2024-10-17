package Lab_3;

	class AgeValidationException extends Exception {
	    public AgeValidationException(String message) {
	        super(message);
	    }
	}

	class Person {
	    private String name;
	    private int age;

	    public Person(String name, int age) throws AgeValidationException {
	        if (age <= 15) {
	            throw new AgeValidationException("Age must be above 15 to create a Person object.");
	        }
	        this.name = name;
	        this.age = age;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public float getAge() {
	        return age;
	    }

	    public void setAge(int age) throws AgeValidationException {
	        if (age <= 15) {
	            throw new AgeValidationException("Age must be above 15.");
	        }
	        this.age = age;
	    }

	    @Override
	    public String toString() {
	        return "Person [name=" + name + ", age=" + age + "]";
	    }
	}

	class Account {
	    private long accNum;
	    private double balance;
	    private Person accHolder;
	    private static long accCounter = 1000;

	    public Account(Person accHolder, double initialBalance) {
	        this.accHolder = accHolder;
	        this.balance = initialBalance;
	        this.accNum = accCounter++; 
	    }

	    public long getAccNum() {
	        return accNum;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

	    public Person getAccHolder() {
	        return accHolder;
	    }

	    public void setAccHolder(Person accHolder) {
	        this.accHolder = accHolder;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited INR " + amount + " to account: " + accNum);
	        } else {
	            System.out.println("Invalid deposit amount");
	        }
	    }

	    public boolean withdraw(double amount) {
	        if (amount > 0 && (balance - amount >= 500)) {
	            balance -= amount;
	            System.out.println("Withdrew INR " + amount + " from account: " + accNum);
	            return true;
	        } else {
	            System.out.println("Insufficient balance or minimum balance requirement not met");
	            return false;
	        }
	    }

	    @Override
	    public String toString() {
	        return "Account [accNum=" + accNum + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	    }
	}

	public class AgeValidation_2 {
	    public static void main(String[] args) {
	        try {
	            Person smith = new Person("Smith", 14);
	            Person kathy = new Person("Kathy", 28);	      

	            Account smithAccount = new Account(smith, 2000);
	            Account kathyAccount = new Account(kathy, 3000);

	            smithAccount.deposit(2000);
	            kathyAccount.withdraw(2000);

	            System.out.println("Updated balance in Smith's account: " + smithAccount.getBalance());
	            System.out.println("Updated balance in Kathy's account: " + kathyAccount.getBalance());

	            System.out.println(smithAccount);
	            System.out.println(kathyAccount);
	        } catch (AgeValidationException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}

