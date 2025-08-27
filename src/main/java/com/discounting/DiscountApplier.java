package com.discounting;

public class DiscountApplier {

    private IDiscountStrategy strategy;

    public DiscountApplier(IDiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IDiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double amount) {
        if (strategy == null) throw new IllegalStateException("Discount strategy not set");
        return strategy.apply(amount);
    }
}
