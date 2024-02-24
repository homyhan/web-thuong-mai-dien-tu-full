package web.webbanhang.user;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.webbanhang.jpa.RoleJpa;
import web.webbanhang.jpa.UserJpa;
import web.webbanhang.role.Role;

@RestController
public class UserController {
	
	private UserJpa userRepository;	
	private RoleJpa roleRepository; 
	
	
	public UserController(UserJpa userRepository, RoleJpa roleRepository) {
		
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return userRepository.findAll();
	}
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User addedUser = userRepository.save(user);
		
		return ResponseEntity.noContent().build();
	}
	
//	@PostMapping("/users")
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//	    // Tìm kiếm role với id tương ứng hoặc trả về null nếu không tìm thấy
//	    Optional<Role> roleOpt = roleRepository.findById(1);
//	    
//	    // Kiểm tra xem role có tồn tại hay không
//	    if (roleOpt.isPresent()) {
//	        Role role = roleOpt.get();
//	        user.setRole(role);
//	        User addedUser = userRepository.save(user);
//	        System.out.println(addedUser);
//	        return ResponseEntity.noContent().build();
//	    } else {
//	        // Nếu không tìm thấy role, trả về lỗi hoặc xử lý theo ý muốn của bạn
//	    	System.out.println("loi");
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Hoặc trả về phản hồi lỗi
//	    }
//	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> requestBody) {
		String fullName = requestBody.get("fullName");
        String password = requestBody.get("password");
	    User user = userRepository.findByFullName(fullName);
	    if (user == null || !user.getPassword().equals(password)) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid fullname or password");
	    }
	    
	    return ResponseEntity.ok("Login successful");
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		userRepository.deleteById(id);
		
	}
	
	 @PutMapping("/users/{id}")
	    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
	        Optional<User> existingUser = userRepository.findById(id);
	        
	        if (existingUser == null) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        User userNew = existingUser.get();
	        
	        // Cập nhật thông tin của người dùng với dữ liệu từ updatedUser
	        userNew.setFullName(updatedUser.getFullName());
	        userNew.setPassword(updatedUser.getPassword());
	        userNew.setAddress(updatedUser.getAddress());
	        userNew.setPhone(updatedUser.getPhone());
	        // Thêm các trường thông tin khác cần cập nhật
	        
	        User userChanged = userRepository.save(userNew);
	        
	        return ResponseEntity.ok("User information updated successfully");
	    }
	 
	 @GetMapping("/users/{id}")
	 public User getUserById(@PathVariable int id) {
		 Optional<User> userRes = userRepository.findById(id);
		 User user= userRes.get();
		 return user;
	 }

}
