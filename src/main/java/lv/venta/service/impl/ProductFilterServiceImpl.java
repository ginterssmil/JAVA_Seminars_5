package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductFilterService;

@Service
public class ProductFilterServiceImpl implements IProductFilterService{

	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public ArrayList<Product> filterByPriceLessThan(float threshold) throws Exception {

		if(threshold <= 0 ) {
			throw new Exception("Ievaditajai cenai jabut pozitivai");
		}
		
		ArrayList<Product> result = prodRepo.findByPriceLessThan(threshold);
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu kuru cena ir mazaka ka "+ threshold);
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> filterByType(ProductType type) throws Exception {

		if(type == null ) {
			throw new Exception("nav noradits pareizs tips");
		}
		
		ArrayList<Product> result = prodRepo.findByProductTypeEquals(type);
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu ar tipu " + type);
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> filterByKeyword(String keyword) throws Exception {
		
		if( keyword==null || keyword.isEmpty() ) {
			throw new Exception("vards nav ievadits pareizi");
		}
		
		ArrayList<Product> result = prodRepo.findByTitleContainingOrDescriptionContaining(keyword, keyword);
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu kas satur vardu" + keyword);
		}
		
		return result;
	}
	
	@Override
	public float calculateAvgPrice() throws Exception {
		if(prodRepo.count() == 0) {
			throw new Exception("DB nav produktu un nevar aprekinat videjo cenu");
		}
		
		float result = prodRepo.calculateAvgPriceFromDB();
		return result;
	}

	
}
