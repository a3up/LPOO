package com.aor.refactoring.example3;

public class SimpleOrder {
    private double price;
    private Discount discount = new NullDiscount();

    public SimpleOrder(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
