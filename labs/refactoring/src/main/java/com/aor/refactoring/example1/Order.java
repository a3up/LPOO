package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines = new ArrayList<>();
    double total = 0;

    public void add(Product product, int quantity) {
        OrderLine toAdd = new OrderLine(product, quantity);
        lines.add(toAdd);
        total += toAdd.getTotal();
    }

    public boolean isEligibleForFreeDelivery() {
        return total > 100;
    }

    public String printOrder() {
        StringBuilder printBuffer = new StringBuilder();

        for (OrderLine line : lines)
            printBuffer.append(line.toString()).append("\n");

        printBuffer.append("Total: ").append(total);

        return printBuffer.toString();
    }
}