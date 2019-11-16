package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateServiceInterface candidates;

	@Autowired
	CandidateMapper mapper;

	@GetMapping("/{userId}/{accelerationId}/{companyId}")
	public CandidateDTO findById(@PathVariable Optional<Long> userId,
			@PathVariable Optional<Long> accelerationId, 
			@PathVariable Optional<Long> companyId) {
		if (userId.isPresent() && accelerationId.isPresent() && companyId.isPresent()) {
			return mapper.map(candidates.findById(userId.get(), companyId.get(), accelerationId.get()).get());	
		}
		return null;
	}	

	@GetMapping
	public List<CandidateDTO> findAll(@RequestParam(required = false) Optional<Long> companyId, 
			@PathVariable(required = false) Optional<Long> accelerationId) {
		
		if(companyId.isPresent()) {
			return mapper.map(candidates.findByCompanyId(companyId.get()));
		} else if(accelerationId.isPresent()) {
			return mapper.map(candidates.findByAccelerationId(accelerationId.get()));
		}
		
		return null;

	}
}
