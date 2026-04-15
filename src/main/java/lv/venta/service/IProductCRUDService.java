package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.*;

public interface IProductCRUDService {

	public abstract void create(String title, float price, int quantity, String description, ProductType type) throws Exception;

	public abstract ArrayList<Product> retrieveAll() throws Exception;

	public abstract Product retrieveById(long id) throws Exception;
	
	public abstract void updateById(long id, String title, float price, int quantity, String description, ProductType type) throws Exception;

	public abstract void deleteById(long id) throws Exception;


}
