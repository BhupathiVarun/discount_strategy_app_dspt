package com.discounting;

public class NoDiscount implements IDiscountStrategy
{


    @Override
    public double apply(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be >= 0");
        return amount;
    }
}
