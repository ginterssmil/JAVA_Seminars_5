package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductFilterService {

	//izfilter produktus pec cenas slieksna
	public abstract ArrayList<Product> filterByPriceLessThan(float threshold) throws Exception;
	
	//izfiltre produktus pec tip
	public abstract ArrayList<Product> filterByType(ProductType type) throws Exception;
	
	//izfiltre produktus pec padota keyword un skatas title un description
	public abstract ArrayList<Product> filterByKeyword(String keyword) throws Exception;

	public abstract float calculateAvgPrice() throws Exception;
}
