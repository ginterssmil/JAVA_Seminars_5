package lv.venta.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
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
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z ]{2,30}")
	private String title;
	
	@Column(name = "Price")
	@Min(0)
	@Max(1000)
	private float price;
	
	@Column(name = "Quantity")
	@Min(0)
	@Max(500)
	private int quantity;
	
	@Column(name = "Description")
	@NotNull(message = "Aprakstam jabut realam")
	@Pattern(regexp = "[A-Za-z ,.0-9]{0,400}")
	private String description;
	
	@Column(name = "ProductType")
	@NotNull
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
