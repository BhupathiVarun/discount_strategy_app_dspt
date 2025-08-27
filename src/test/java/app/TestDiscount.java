package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDiscount {

    @Test
    void FixedRateDiscount(){
        DiscountApplier calc = new DiscountApplier(new FixedRateDiscount(0.25));
        assertEquals(75.0, calc.calculate(100.0), 1e-9);
    }

    @Test
    void NoDiscount(){
        double price = 1500;
        DiscountApplier calc = new DiscountApplier(new FixedRateDiscount(0.4));
        assertEquals(900, calc.calculate(price), 1e-9);
    }

    @Test
    void ThresholdDiscounter(){
        double amt = 2000;
        DiscountApplier calc = new DiscountApplier(new ThresholdDiscount(1000,200));
        assertEquals(1800, calc.calculate(amt), 1e-9);
    }




}
