package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

@Controller
@RequestMapping("/simple")
public class SimpleController {

	@GetMapping("/page")//localhost:8080/simple/page
	public String getShowPage() {
		System.out.println("Mans pirmais kontrolieris ir izsaukts");
		return "show-page";//tiks paradita show-page.html lapa ieks parluka
	}
	@GetMapping("/data") //localhost:8080/simple/data
	public String getDataInPage(Model model) {
		System.out.println("Izpildas datu kontrolieris");
		Random rand = new Random();
		String data = "@Gint" + rand.nextInt(2010,2026);
		model.addAttribute("package", data);
		return "show-data-page";//tiks paradita show-data-page.html
	}
	
	@GetMapping("/product") //localhost:8080/simple/product
	public String getProductInPage(Model model) {
		Product prod = new Product("Abols", (float)0.99, 5, "Taizemes", ProductType.fruit);
		model.addAttribute("package", prod);
		return "show-one-product-page";//tiks paradita show-one-product-page.html
	}
	

	@GetMapping("/products")//localhost:8080/simple/products
	public String getAllProductsInPage(Model model) {
		Product prod1 = new Product("Abols", (float)0.99, 5, "Polija", ProductType.fruit);
		Product prod2 = new Product("Burkans", (float)0.39, 5, "oranzs", ProductType.vegetable);
		Product prod3 = new Product("Arbuzs", (float)4.59, 20, "bez seklam", ProductType.fruit);

		ArrayList<Product> allProducts = new ArrayList<Product>(Arrays.asList(prod1, prod2, prod3));
		
		model.addAttribute("package", allProducts);
		return "show-all-products-page";
		
	}
	
	
	@GetMapping("/add")//localhost:8080/simple/add
	public String getAddNewProduct(Model model) {
		//lai izveidotu produktu, iedodam nokluseto produktu, kuru pec tam vares aizpildit html puse
		model.addAttribute("product", new Product());
		return "add-new-product-page";	
	}
	
	@PostMapping("/add")
	public String postAddNewProduct(Product product) {
		System.out.println(product);
		return "redirect:/simple/page";
	}
}
