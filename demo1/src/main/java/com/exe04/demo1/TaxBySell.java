package com.exe04.demo1;

public class TaxBySell implements ITaxs {
    public double applyTax(double total) {
        return total * 0.05;
    }
}
