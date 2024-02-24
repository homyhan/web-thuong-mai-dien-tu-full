package web.webbanhang.nav;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemNav {
	protected ItemNav() {
		
	}
	@Id
	@GeneratedValue
	private int id;
	private String name;
	 @ManyToOne
	 @JoinColumn(name = "nav_id")
	 private Nav nav;
	public ItemNav(int id, String name, Nav nav) {
		super();
		this.id = id;
		this.name = name;
		this.nav = nav;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Nav getNav() {
		return nav;
	}
	public void setNav(Nav nav) {
		this.nav = nav;
	}
	@Override
	public String toString() {
		return "ItemNav [id=" + id + ", name=" + name + ", nav=" + nav + "]";
	}
	
	

	
}
