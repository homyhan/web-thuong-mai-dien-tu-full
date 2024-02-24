package web.webbanhang.user;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import web.webbanhang.card.Card;
import web.webbanhang.product.Product;
import web.webbanhang.role.Role;
@Entity
public class User {
	protected User() {
		
	}
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="fullname")
	private String fullName;
	private Date dob;
	private String address;
	private String phone;
	private String password;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Card> cards;
	
//	@ManyToOne
//	@JoinColumn(name="role_id")
//	private Role role;
	
	public User(int id, String fullName, Date dob, String address, String phone, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", address=" + address + ", phone="
				+ phone + ", password=" + password + "]";
	}
	
	
	
	
}
