package app;

/**
 * A concrete implementation of {@link IDiscountStrategy}
 * that provides no discount.
 * <p>
 * This strategy simply returns the original amount unchanged.
 * </p>
 */
public class NoDiscount implements IDiscountStrategy {

    /**
     * Returns the original amount without any modification.
     * Throws an {@link IllegalArgumentException} if the amount is negative.
     *
     * @param amount the original purchase amount
     * @return the same amount (no discount applied)
     * @throws IllegalArgumentException if {@code amount} is less than 0
     */
    @Override
    public double apply(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        return amount;
    }
}
