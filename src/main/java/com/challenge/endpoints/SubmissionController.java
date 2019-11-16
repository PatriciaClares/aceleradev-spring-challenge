package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

	@Autowired
	private SubmissionServiceInterface submissions;
	
	@Autowired
	private SubmissionMapper mapper;
	
	@GetMapping
	public List<SubmissionDTO> findAll(@RequestParam(required=false) Optional<Long>challengeId,
			@RequestParam(required=false) Optional<Long> accelerationId){
		if(challengeId.isPresent() && accelerationId.isPresent())
			return mapper.map(submissions.findByChallengeIdAndAccelerationId(challengeId.get(), accelerationId.get()));
		
		return null;
}

}