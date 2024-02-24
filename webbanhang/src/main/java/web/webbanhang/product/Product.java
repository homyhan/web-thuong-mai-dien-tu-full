package web.webbanhang.product;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import web.webbanhang.card.Card;
import web.webbanhang.user.User;

@Entity
public class Product {
	protected Product() {
		
	}
	@Id
	@GeneratedValue
	private int id;
	@Column(name="prodname")
	private String prodName;
	private String image;
	private double price;
	@Column(name="percentsale")
	private double percentSale;
	private int quantity;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Card> cards;
	

	public Product(int id, String prodName, String image, double price, double percentSale, int quantity) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.image = image;
		this.price = price;
		this.percentSale = percentSale;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPercentSale() {
		return percentSale;
	}
	public void setPercentSale(double percentSale) {
		this.percentSale = percentSale;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", prodName=" + prodName + ", image=" + image + ", price=" + price
				+ ", percentSale=" + percentSale + ", quantity=" + quantity + "]";
	}
	
	
}
