package com.exe04.demo1;

public class CalculateDiscount {
    private IDiscounts discount;

    public CalculateDiscount(IDiscounts discount) {
        this.discount = discount;
    }

    public double calculate(double total) {
        return discount.applyDiscounts(total);
    }
}
