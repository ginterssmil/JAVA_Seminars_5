package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import lv.venta.model.*;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductCRUDServiceimpl implements IProductCRUDService{
	
	private final CommandLineRunner testRepo;
	@Autowired
	private IProductRepo prodRepo;

	ProductCRUDServiceimpl(CommandLineRunner testRepo) {
		this.testRepo = testRepo;
	}
	
	@Override
	public void create(String title, float price, int quantity, String description, ProductType type) throws Exception {
		if(title == null || !title.matches("[A-Za-z ]{2,30}")
				|| price < 0 || price > 1000
				|| quantity <0 || quantity > 100
				|| description == null || !description.matches("[A-Za-z ,.0-9]{0,400}")
				|| type == null) {
			throw new Exception("Kads no ievades argumentiem nav atbilstoss");
		}
		
		//parbaudam, vai tads produkts jau eksiste, ja ta, tad papildinam krajumus
		if(prodRepo.existsByTitleAndPriceAndDescriptionAndProductType(title, price, description, type)) {
			Product productFromDB = prodRepo.findByTitleAndPriceAndDescriptionAndProductType(title, price, description, type);
			
			int newQuantity = productFromDB.getQuantity() + quantity;
			productFromDB.setQuantity(newQuantity);
			prodRepo.save(productFromDB);
		}
		else {
			Product newProduct = new Product(title, price, quantity, description, type);
			prodRepo.save(newProduct);
		}
		
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(prodRepo.count()==0) {
			throw new Exception("Produkta tabula DB ir tuksa");
		}
		
		ArrayList<Product> allProductsFromDB =(ArrayList<Product>) prodRepo.findAll();
		return allProductsFromDB;
	}

	@Override
	public Product retrieveById(long id) throws Exception {
		if(id <=0 || !prodRepo.existsById(id)) {
			throw new Exception("id nevar but negativs vai nulle, vai nepastav produkts ar tadu id");
		}
		Product productFromDB = prodRepo.findById(id).get();
		return productFromDB;
	}

	@Override
	public void updateById(long id, String title, float price, int quantity, String description, ProductType type)
			throws Exception {
		Product productFromDB = retrieveById(id);
		
		if(title == null || !title.matches("[A-Z]{1}[a-z]{2,30}")
				|| price < 0 || price > 1000
				|| quantity <0 || quantity > 100
				|| description == null || !description.matches("[A-Za-z ,.0-9]{0,400}")
				|| type == null) {
			throw new Exception("Kands no ievades argumentiem nav atbilstoss");
		}
		if(!productFromDB.getTitle().equals(title)) {
		productFromDB.setTitle(title);
		}
		if(productFromDB.getPrice() != price) {
		productFromDB.setPrice(price);
		}
		if(productFromDB.getQuantity() != quantity) {
		productFromDB.setQuantity(quantity);
		}
		if(!productFromDB.getDescription().equals(description)) {
		productFromDB.setDescription(description);
		}
		if(!productFromDB.getProductType().equals(type)) {
		productFromDB.setProductType(type);
		}
		prodRepo.save(productFromDB);
	}

	@Override
	public void deleteById(long id) throws Exception {
		Product productFromDB = retrieveById(id);
		prodRepo.delete(productFromDB);
	}

}
