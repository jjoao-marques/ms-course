package com.devsuperior.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.Utils.MessageUtil;
import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.exceptions.UserNotFoundException;
import com.devsuperior.hruser.repositories.UserRepository;



@RestController
@RequestMapping(value = "/users")
public class UserResource {
		
	@Autowired
	private UserRepository repository;

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		 User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(MessageUtil.USER_NOT_FOUND));
		 return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}

