package app;

/**
 * Mediator class to apply the discount strategy.
 */
public class DiscountApplier {

    /**
     * The discount strategy to be applied.
     */
    private IDiscountStrategy strategy;

    /**
     * Constructs a DiscountApplier with the given strategy.
     *
     * @param newStrategy the discount strategy
     */
    public DiscountApplier(final IDiscountStrategy newStrategy) {
        this.strategy = newStrategy;
    }

    /**
     * Updates the discount strategy.
     *
     * @param newStrategy the new discount strategy
     */
    public void setStrategy(final IDiscountStrategy newStrategy) {
        this.strategy = newStrategy;
    }

    /**
     * Calculates the discounted amount using the current strategy.
     *
     * @param amount the original amount
     * @return the discounted amount
     * @throws IllegalStateException if no strategy is set
     */
    public double calculate(final double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Discount strategy not set");
        }
        return strategy.apply(amount);
    }
}
