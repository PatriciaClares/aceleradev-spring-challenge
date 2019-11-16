package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyServiceInterface companies;

	@GetMapping("/{id}")
	public Company findById(@PathVariable Long id) {
		return companies.findById(id).orElse(null);
	}

	@GetMapping
	public List<Company> findAll(@RequestParam Optional<Long> accelerationId, @RequestParam Optional<Long> userId) {
		if (accelerationId.isPresent())
			return companies.findByAccelerationId(accelerationId.get());
		if (userId.isPresent())
			return companies.findByUserId(userId.get());
		
		return null;
	}
}
