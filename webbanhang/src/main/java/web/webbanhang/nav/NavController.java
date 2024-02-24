package web.webbanhang.nav;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import web.webbanhang.jpa.ItemNavJpa;
import web.webbanhang.jpa.NavJpa;

@RestController
public class NavController {
	private NavJpa navRepository;
	private ItemNavJpa itemNavRepository;

	public NavController(NavJpa navRepository, ItemNavJpa itemNavRepository) {
		super();
		this.navRepository = navRepository;
		this.itemNavRepository = itemNavRepository;
	}

	@PostMapping("/navs")
	public void addNav(@RequestBody Nav nav) {
		navRepository.save(nav);
	}
	@GetMapping("/navs")
	public List<Nav> getListNav(){
		return navRepository.findAll();
	}
	
	@PostMapping("/item-navs")
	public void addItemNavs(@RequestBody ItemNav itemNav) {
		itemNavRepository.save(itemNav);
	}
	
	@GetMapping("/item-navs")
	public List<ItemNav> getListItemNav(){
		return itemNavRepository.findAll();
	}
	
	@DeleteMapping("/item-navs")
	public ResponseEntity<String> deleteItemNav(@PathVariable int id) {
		Optional<ItemNav> itemNavRes = itemNavRepository.findById(id);
		
		if(itemNavRes== null) {
			return ResponseEntity.ok("Không tìm thấy kết quả");
		}else {
			itemNavRepository.deleteById(id);
		}
		return ResponseEntity.ok("Đã xóa item nav thành công");
	}
	
	@DeleteMapping("/navs")
	public ResponseEntity<String> deleteNav(@PathVariable int id) {
		Optional<Nav> navRes = navRepository.findById(id);
		
		if(navRes== null) {
			return ResponseEntity.ok("Không tìm thấy kết quả");
		}else {
			navRepository.deleteById(id);
		}
		return ResponseEntity.ok("Đã xóa nav thành công");
	}
	
	@PutMapping("/navs")
	public ResponseEntity<String> updateNav(@PathVariable int id, @RequestBody Nav nav) {
		
		Optional<Nav> navRes = navRepository.findById(id);
		if(navRes==null) {
			return ResponseEntity.ok("Không tìm thấy nav");
		
		}else {
			Nav navObj = navRes.get();
			navObj.setName(nav.getName());
			
			navRepository.save(navObj);
		}
		
		return ResponseEntity.ok("Đã cập nhật thông tin nav thành công");
	}

}
