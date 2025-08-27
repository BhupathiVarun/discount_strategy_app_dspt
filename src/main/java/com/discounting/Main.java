package com.discounting;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double amount = 3000;

        DiscountApplier calc = new DiscountApplier(new FixedRateDiscount(0.4));
        System.out.println("40% off: " + calc.calculate(amount));

        calc.setStrategy(new ThresholdDiscount(1500,400));// $400 off when >= 1500
        System.out.println("$400 off >=1500: " + calc.calculate(amount));
        System.out.println("$400 off >=1500: " + calc.calculate(1499));

        calc.setStrategy(new NoDiscount());//
        System.out.println("No discount: " + calc.calculate(amount));
        System.out.println("No discount: " + calc.calculate(1499));

    }
}