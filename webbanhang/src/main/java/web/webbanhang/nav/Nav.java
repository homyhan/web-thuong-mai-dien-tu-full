package web.webbanhang.nav;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Nav { 
	
	protected Nav() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy = "nav")
	@JsonIgnore
	private List<ItemNav> listNav;
	public Nav(int id, String name, List<ItemNav> listNav) {
		super();
		this.id = id;
		this.name = name;
		this.listNav = listNav;
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
	public List<ItemNav> getListNav() {
		return listNav;
	}
	public void setListNav(List<ItemNav> listNav) {
		this.listNav = listNav;
	}
	@Override
	public String toString() {
		return "Nav [id=" + id + ", name=" + name + ", listNav=" + listNav + "]";
	}
	
	

}
