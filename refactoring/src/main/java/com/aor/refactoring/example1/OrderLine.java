package com.aor.refactoring.example1;

public class OrderLine {
    private final Product product;
    private final int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice()*quantity;
    }

    @Override
    public String toString() {
        return product.getName() + "(x" + quantity + "): " + (product.getPrice() * quantity) + "\n";
    }
}
