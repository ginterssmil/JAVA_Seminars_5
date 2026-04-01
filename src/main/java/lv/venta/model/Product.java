package lv.venta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
	private long id;
	private String title;
	private float price;
	private int quantity;
	private String description;
	private ProductType productType;
	
	//getters - nak no lombok bibliotekas
	//setters - nak no lombok bibliotekas
	
	public Product(String inputTitle, float inputPrice, int inputQuantity, String inputDescription,ProductType inputProductType) {
		setTitle(inputTitle);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
		setDescription(inputDescription);
		setProductType(inputProductType);
	}
}
