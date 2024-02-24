package web.webbanhang.role;

import org.springframework.web.bind.annotation.*;

import web.webbanhang.jpa.RoleJpa;

@RestController
public class RoleController {
	
	private RoleJpa roleRepository;

	public RoleController(RoleJpa roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@PostMapping("/roles")
	public void createRoles(@RequestBody Role role) {
		roleRepository.save(role);
	}
}
