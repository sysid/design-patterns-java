package sysid.strategy;

@FunctionalInterface
public interface BillingStrategy {
    // normal billing strategy
    static BillingStrategy normalStrategy() {
        return rawPrice -> rawPrice;
    }

    // happy hour billing strategy
    static BillingStrategy happyHourStrategy() {
        return rawPrice -> rawPrice / 2;
    }

    int getActPrice(int rawPrice);
}
