package sysid.strategy;

import java.util.ArrayList;
import java.util.List;

// context
public class CustomerBill {
    private final List<Integer> drinks = new ArrayList<>();
    private BillingStrategy strategy;

    public CustomerBill(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    void add (int price, int quantity) {
        this.drinks.add(this.strategy.getActPrice(price*quantity));
    }

    // payment of bill
    void print() {
        int sum = drinks.stream().mapToInt(v -> v).sum();
        System.out.println("Total due: " + sum);
        drinks.clear();
    }

    // set strategy
    void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }
}
