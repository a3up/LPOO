package com.aor.refactoring.example3;

public class NullDiscount implements Discount {
    boolean isNull() {
        return true;
    }

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
