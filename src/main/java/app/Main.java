package app;

/**
 * Demonstrates execution of all discount types.
 */
public class Main {

    /** Initial amount for discount calculations. */
    private static final double INITIAL_AMOUNT = 3000;

    /** Discount rate for fixed rate discount. */
    private static final double DISCOUNT_RATE = 0.4;

    /** Threshold for threshold discount. */
    private static final double THRESHOLD = 1500;

    /** Fixed discount amount applied when threshold is met. */
    private static final double DISCOUNT_AMOUNT = 400;

    /** Test amount below threshold. */
    private static final double BELOW_THRESHOLD_AMOUNT = 1499;

    /**
     * Main entry point of the application.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        final double amount = INITIAL_AMOUNT;

        final DiscountApplier calc = new DiscountApplier(new FixedRateDiscount(DISCOUNT_RATE));
        System.out.println("FixedRateDiscount 40% off: " + calc.calculate(amount));

        calc.setStrategy(new ThresholdDiscount(THRESHOLD, DISCOUNT_AMOUNT));
        System.out.println("ThresholdDiscount $400 off >=1500: " + calc.calculate(amount));
        System.out.println("ThresholdDiscount $400 off >=1500: " + calc.calculate(BELOW_THRESHOLD_AMOUNT));

        calc.setStrategy(new NoDiscount());
        System.out.println("No discount: " + calc.calculate(amount));
        System.out.println("No discount: " + calc.calculate(BELOW_THRESHOLD_AMOUNT));
    }
}
