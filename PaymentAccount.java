// PaymentAccount.java
public class PaymentAccount {
    private double balance;

    public PaymentAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        System.out.println("Withdrew UGX " + amount + ". New balance: UGX " + balance);
    }

    public static void main(String[] args) {
        PaymentAccount account = new PaymentAccount(100000.0);
        try {
            account.withdraw(50000);
            account.withdraw(80000);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.println("Shortfall amount: UGX " + e.getShortfall());
        }
    }
}