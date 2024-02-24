package web.webbanhang.card;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import web.webbanhang.product.Product;
import web.webbanhang.user.User;

@Entity
public class Card {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public Card(int id, User user, Product product) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", user=" + user + ", product=" + product + "]";
	}
	
	
	
}
