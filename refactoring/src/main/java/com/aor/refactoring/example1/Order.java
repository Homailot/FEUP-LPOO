package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    private double getTotal() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.getTotal();

        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        return (getTotal() > 100);
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line);

        printBuffer.append("Total: " + getTotal());

        return printBuffer.toString();
    }
}
