package app;

/**
 * Discount strategy for applying a fixed rate discount.
 * The rate should be between 0 and 1 (representing percentage).
 */
public class FixedRateDiscount implements IDiscountStrategy {

    /**
     * The discount rate to be applied.
     */
    private final double rateDiscount;

    /**
     * Constructs a FixedRateDiscount with the given rate.
     *
     * @param newRateDiscount the discount rate (must be between 0 and 1)
     * @throws IllegalArgumentException if the rate is not in [0, 1]
     */
    public FixedRateDiscount(final double newRateDiscount) {
        if (newRateDiscount < 0 || newRateDiscount > 1) {
            throw new IllegalArgumentException("Rate should be between 0 and 1.");
        }
        this.rateDiscount = newRateDiscount;
    }

    /**
     * Applies the discount to the given amount.
     *
     * @param amount the original amount
     * @return the discounted amount
     * @throws IllegalArgumentException if the amount is negative
     */
    @Override
    public double apply(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be non-negative.");
        }
        return (1 - rateDiscount) * amount;
    }
}
