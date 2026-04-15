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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
