package Lab_2;

class SavingsAccount extends Account {
    private static final double MINIMUM_BALANCE = 500.0;

    public SavingsAccount(double initialBalance, Person accHolder) {
        super(accHolder, initialBalance);
    }
    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount >= MINIMUM_BALANCE) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew " + amount + ". New balance: " + getBalance());
            return true;
        } else {
            System.out.println("Withdrawal denied! Minimum balance must be maintained.");
            return false;
        }
    }
}
