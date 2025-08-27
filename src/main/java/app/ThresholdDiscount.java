package app;

/**
 * A discount strategy that applies a fixed discount amount
 * if the product price meets or exceeds a specified threshold.
 * This class is an immutable data carrier, implemented as a record.
 *
 * @param threshold      The minimum price required to apply the discount.
 * @param discountAmount The fixed amount to be subtracted if the threshold is met.
 */
public record ThresholdDiscount(double threshold, double discountAmount) implements IDiscountStrategy {

    /**
     * Compact constructor for validation.
     *
     * @throws IllegalArgumentException if any of the numeric constraints are violated.
     */
    public ThresholdDiscount {
        if (threshold < 0) {
            throw new IllegalArgumentException("Threshold must be non-negative.");
        }
        if (discountAmount < 0) {
            throw new IllegalArgumentException("Discount amount must be non-negative.");
        }
        if (discountAmount > threshold) {
            throw new IllegalArgumentException("Discount cannot exceed the threshold value.");
        }
    }

    /**
     * Applies the discount if the given amount meets or exceeds the threshold.
     *
     * @param amount The original amount to apply the discount to. Must be non-negative.
     * @return The new amount after the discount is applied, or the original amount if the threshold is not met.
     * @throws IllegalArgumentException if the amount is negative.
     */
    @Override
    public double apply(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }

        if (amount >= this.threshold) {
            return amount - this.discountAmount;
        } else {
            return amount;
        }
    }
}