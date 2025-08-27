package app;

/**
 * Represents an interface for various discount strategies.
 */
public interface IDiscountStrategy {

    /**
     * Applies a discount to the given amount.
     *
     * @param amount the original amount
     * @return the discounted amount
     */
    double apply(double amount);
}
