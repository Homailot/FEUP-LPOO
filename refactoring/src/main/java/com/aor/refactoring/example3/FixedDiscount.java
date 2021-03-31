package com.aor.refactoring.example3;

public class FixedDiscount extends Discount{
    private final int fixed;

    FixedDiscount(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public double applyDiscount(double price) {
        return fixed > price ? 0 : price - fixed;
    }
}
