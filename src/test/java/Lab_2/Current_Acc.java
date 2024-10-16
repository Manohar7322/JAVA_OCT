package Lab_2;

class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 100000.0;

    public CurrentAccount(double initialBalance, Person accHolder) {
        super(accHolder, initialBalance);
    }
    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew " + amount + ". New balance: " + getBalance());
            return true;
        } else {
            System.out.println("Withdrawal denied! Overdraft limit exceeded.");
            return false;
        }
    }
}