package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	@Setter(value = AccessLevel.NONE)
	private long id;
	private String title;
	private float price;
	private int quantity;
	private String description;
	private ProductType productType;
	
	private static long counter = 0;
	//getters - nak no lombok bibliotekas
	//setters - nak no lombok bibliotekas
	
	public Product(String inputTitle, float inputPrice, int inputQuantity, String inputDescription,ProductType inputProductType) {
		setTitle(inputTitle);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
		setDescription(inputDescription);
		setProductType(inputProductType);
		id = counter++;
	}
	
	//toString - nak no lombok bibliotekas
}
