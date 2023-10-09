package com.exe04.demo1;

public class CalculateTax {
    private ITaxs tax;

    public CalculateTax(ITaxs tax) {
        this.tax = tax;
    }

    public double calculate(double total) {
        return tax.applyTax(total);
    }
}
