package com.exe04.demo1;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class Endpoints {
	private List<Product> catalog;

	public Endpoints() {
		catalog = StockRepository.getInstance().listAll();
	}

	@GetMapping("/catalog")
    @CrossOrigin(origins = "*")
	public List<Product> catalog() {
		return catalog;
	}

	@GetMapping("/makeSell")
    @CrossOrigin(origins = "*")
	public double makeSell(@RequestParam(value = "code") String code, @RequestParam(value = "amount") int amount) {
		Product product = StockRepository.getInstance().listAll().stream()
					  								   .filter(p -> p.getCode().equals(code))
					  								   .findFirst()
					  								   .get();
		
		if(product.getAmount() < amount) {
			return -1;
		}

		// Tem que atualizar o estoque!!!
		StockRepository.getInstance().updateProductAmount(code, product.getAmount() - amount);

		return product.getPrice() * amount;

	}

	@GetMapping("/addStock")
    @CrossOrigin(origins = "*")
	public void addStock(@RequestParam(value = "code") String code, @RequestParam(value = "amount") int amount) {
		Product product = StockRepository.getInstance().listAll().stream()
					  								   .filter(p -> p.getCode().equals(code))
					  								   .findFirst()
					  								   .get();

		StockRepository.getInstance().updateProductAmount(code, product.getAmount() + amount);
	}

	@GetMapping("/lowStock")
    @CrossOrigin(origins = "*")
	public List<String> lowStock() {
		return StockRepository.getInstance().lowStock();
	}

}
