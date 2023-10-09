package com.exe04.demo1;

public class Sell {
    public double makeSell(String code, int amount) {
        Product product = StockRepository.getInstance().listAll().stream()
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .get();

        if(product.getAmount() < amount) {
            return -1;
        }

        // Tem que atualizar o estoque!!!
        StockRepository.getInstance().updateProductAmount(code, product.getAmount() - amount);

        double total = product.getPrice() * amount;
        CalculateTax tax = new CalculateTax(new TaxBySell());
        double taxValue = tax.calculate(total);

        if(amount > 10){
            CalculateDiscount discount = new CalculateDiscount(new DiscountByAmount());
            double discountValue = discount.calculate(total);
            return total + taxValue - discountValue;
        }

        return total + taxValue;
    }
}
