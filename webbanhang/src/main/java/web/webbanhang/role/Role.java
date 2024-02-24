package web.webbanhang.role;

import java.util.List;

import jakarta.persistence.*;
import web.webbanhang.user.User;

@Entity
public class Role {
	protected Role() {
		
	}
	@Id
	@GeneratedValue
	private int id;
	private int role;
	private String nameRole;
	
//	@OneToMany(mappedBy = "role")
//	private List<User> userList;
	
	
	public Role(int id, int role, String nameRole) {
		super();
		this.id = id;
		this.role = role;
		this.nameRole = nameRole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

//	public List<User> getUserList() {
//		return userList;
//	}
//	public void setUserList(List<User> userList) {
//		this.userList = userList;
//	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", nameRole=" + nameRole + "]";
	}
	
}
