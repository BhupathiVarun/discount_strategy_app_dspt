package com.discounting;

public class FixedRateDiscount implements IDiscountStrategy{
    private final double rate_discount;

    public FixedRateDiscount(double rate_discount) {
        if (rate_discount < 0 || rate_discount > 1) {
            throw new IllegalArgumentException("rate should be in between [0,1]");
        }
        this.rate_discount = rate_discount;
    }


    @Override
    public double apply(double amount) {
        if(amount<0){
            throw new IllegalArgumentException("amount should be > 0 ");

        }
        return (1-rate_discount)*amount;
    }
}
