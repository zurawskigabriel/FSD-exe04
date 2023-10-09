package com.exe04.demo1;

public class DiscountByAmount implements IDiscounts {
    public double applyDiscounts(double total) {
        return total * 0.10;
    }
}
