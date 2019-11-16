package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
	
	@Autowired
	private ChallengeServiceInterface challenges;
	
	@GetMapping
	public List<Challenge> findAll(@RequestParam(required=false) Optional<Long> accelerationId, @RequestParam(required=false) Optional<Long> userId){
		if(accelerationId.isPresent() && userId.isPresent())
			return challenges.findByAccelerationIdAndUserId(accelerationId.get(), userId.get());
		
		return null;
	}

}
