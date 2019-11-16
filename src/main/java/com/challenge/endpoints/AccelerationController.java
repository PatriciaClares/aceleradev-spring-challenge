package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

	@Autowired
	private AccelerationServiceInterface accelerations;
	
    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@Valid @PathVariable Optional<Long> id){
    	if(id.isPresent()) return accelerations.findById(id.get());
    	
    	return null;
    }
    
    @GetMapping
    public List<Acceleration> findAll (@RequestParam(required=false) Optional<Long> companyId){
    	if(companyId.isPresent()) 
    		return accelerations.findByCompanyId(companyId.get());
    
    	return null;
    }
}
