package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProductTable")
@Entity
public class Product {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "Title")
	private String title;
	@Column(name = "Price")
	private float price;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "Description")
	private String description;
	@Column(name = "ProductType")
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
	
	//toString - nak no lombok bibliotekas
}
