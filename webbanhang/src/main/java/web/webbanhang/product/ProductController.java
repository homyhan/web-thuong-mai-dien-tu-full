package web.webbanhang.product;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import web.webbanhang.jpa.ProductJpa;

@RestController
public class ProductController {
	private ProductJpa productRepository;

	public ProductController(ProductJpa productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.OK).body("Thêm thành công");
	}
	
	@GetMapping("/products")
	public List<Product> getListProductList() {
		return productRepository.findAll();
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok("Delete successfully");
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		Optional<Product> product = productRepository.findById(id);
		Product prod = product.get();
		return prod;

	}
	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product productNew) {
		Optional<Product> product = productRepository.findById(id);
		Product prod = product.get();
		prod.setImage(productNew.getImage());
		prod.setPercentSale(productNew.getPercentSale());
		prod.setPrice(productNew.getPrice());
		prod.setProdName(productNew.getProdName());
		prod.setQuantity(productNew.getQuantity());
		
		productRepository.save(prod);
		
		return ResponseEntity.ok("Updated");
		
	}
}
