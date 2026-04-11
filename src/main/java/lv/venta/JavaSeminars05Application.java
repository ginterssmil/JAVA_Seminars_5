package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class JavaSeminars05Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminars05Application.class, args);
	}

@Bean	
	public CommandLineRunner testRepo(IProductRepo prodRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Product prod1 = new Product("Abols", (float)0.99, 5, "Polija", ProductType.fruit);
				Product prod2 = new Product("Burkans", (float)0.39, 5, "oranzs", ProductType.vegetable);
				Product prod3 = new Product("Arbuzs", (float)4.59, 20, "bez seklam", ProductType.fruit);
				
				prodRepo.save(prod1);
				prodRepo.save(prod2);
				prodRepo.save(prod3);
				
				
			}
		};
		
	}
}
