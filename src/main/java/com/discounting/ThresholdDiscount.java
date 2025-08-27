package com.discounting;

public class ThresholdDiscount implements IDiscountStrategy {
    private final double threshold;
    private final double discountAmount;

    public ThresholdDiscount(double threshold, double discountAmount) {
        if (threshold < 0 || discountAmount < 0) throw new IllegalArgumentException("must be >= 0");
        this.threshold = threshold;
        this.discountAmount = discountAmount;
    }

    @Override
    public double apply(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be >= 0");
        if(amount>=threshold){
            return amount - discountAmount;
        }
        return amount;
    }

}
