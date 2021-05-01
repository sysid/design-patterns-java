package sysid.bridge;

/**
 * concrete Abstraction
 */
public class SimpleAccount extends AbstractAccount {
    private int balance;

    SimpleAccount(int balance) {
        this.balance = balance;
    }

    boolean isBalanceLow() {
        return balance < 50;
    }

    void withdraw(int amount) {
        boolean shouldPerform = balance >= amount;
        if (shouldPerform) {
            balance -= amount;
        }
        operate("withdraw " + amount, shouldPerform);
    }
}
