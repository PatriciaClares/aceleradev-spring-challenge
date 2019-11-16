package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceInterface users;
	
	@GetMapping
	public List<User> findAll(@RequestParam(required=false) Optional<String> accelerationName, @RequestParam(required=false) Optional<Long> companyId){
		if (accelerationName.isPresent())
			return users.findByAccelerationName(accelerationName.get());
		
		if(companyId.isPresent()) 
			return users.findByCompanyId(companyId.get());
		
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> findById(@Valid @PathVariable Long id){
		return ResponseEntity.ok(users.findById(id));
	}
	
}
