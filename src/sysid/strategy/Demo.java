package sysid.strategy;

public class Demo {
    public static void main(String[] args) {
        // Prep strategies
        BillingStrategy normalStrategy = BillingStrategy.normalStrategy();
        BillingStrategy happyHourStrategy = BillingStrategy.happyHourStrategy();

        CustomerBill firstCustomer = new CustomerBill(normalStrategy);

        // normal billing
        firstCustomer.add(100, 1);

        // start happy hour
        firstCustomer.setStrategy(happyHourStrategy);
        firstCustomer.add(100, 2);

        CustomerBill secondCustomer = new CustomerBill(happyHourStrategy);
        secondCustomer.add(80,1);

        // customer pays
        firstCustomer.print();

        // End happy hour
        secondCustomer.setStrategy(normalStrategy);
        secondCustomer.add(130,2);
        secondCustomer.add(250,1);
        secondCustomer.print();
    }
}
