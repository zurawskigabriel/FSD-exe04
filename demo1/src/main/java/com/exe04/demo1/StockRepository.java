package com.exe04.demo1;

import java.util.List;

public class StockRepository {

	private List<Product> products;
	static StockRepository stockRepository;

	private StockRepository() {
		Product product1 = new Product("1", "product1", 10.0, 6);
		Product product2 = new Product("2", "product2", 100.0, 0);
		Product product3 = new Product("3", "product3", 14.0, 110);
		Product product4 = new Product("4", "product4", 2.0, 8);
		Product product5 = new Product("5", "product5", 10.5, 63);
		Product product6 = new Product("6", "product6", 5.75, 15);
		Product product7 = new Product("7", "product7", 1.5, 23);
		Product product8 = new Product("8", "product8", 64.3, 44);
		Product product9 = new Product("9", "product9", 16.0, 54);
		Product product10 = new Product("10", "product10", 11.0, 100);
		products = List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10);	
	}

	public static StockRepository getInstance() {
		if (stockRepository == null) {
			stockRepository = new StockRepository();
		}
		return stockRepository;
	}

	public List<Product> productByCode(String code) {

		return products.stream()
				       .filter(product -> product.getCode().equals(code))
				       .toList();
	}

	public List<Product> listAll() {
		return products;
	}

	public void creatProduct(Product product) {
		products.add(product);
	}

	public void updateProduct(Product produto) {

	}

	public List<String> lowStock() {
		return products.stream()
						.filter(product -> product.getAmount() < 10)
						.map(product -> product.getCode())
						.toList();
	}

}
