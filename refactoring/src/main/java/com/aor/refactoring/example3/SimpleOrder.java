package com.aor.refactoring.example3;

public class SimpleOrder {
    private final Discount discount;
    private final double price;

    public SimpleOrder(double price, Discount discount) {
        this.price = price;
        this.discount = discount;
    }

    public SimpleOrder(double price) {
        this.price = price;
        this.discount = new NoDiscount();
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
