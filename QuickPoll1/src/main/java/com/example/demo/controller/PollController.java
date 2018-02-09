package com.example.demo.controller;
import java.net.URI;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Poll;
import com.example.demo.repository.PollRepository;

@RestController
public class PollController {
	
	@Autowired
	private PollRepository _pollRepository;
	
	protected void verifyPoll(Long pollId) throws ResourceNotFoundException{
		 Poll poll = _pollRepository.findOne(pollId);
		 if (poll == null ) {
			 throw new ResourceNotFoundException("poll with id "+pollId+"is not found", null);
		 }
	}
	
	@RequestMapping(value ="/polls",method=RequestMethod.GET)
	public ResponseEntity<Iterable<Poll>> getAllPolls(){
		Iterable<Poll> allPolls = _pollRepository.findAll();
		return new ResponseEntity<>(allPolls,HttpStatus.OK);
	}
	
	@RequestMapping(value="/polls",method = RequestMethod.POST)
	public ResponseEntity<?>createPoll (@Valid @RequestBody Poll poll){
		poll = _pollRepository.save(poll);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollUri = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(poll.getId())
		.toUri();
		responseHeaders.setLocation(newPollUri);
		return new ResponseEntity<>(responseHeaders,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
	public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
	Poll p = _pollRepository.findOne(pollId);
	verifyPoll(pollId);
	return new ResponseEntity<> (p, HttpStatus.OK);
	}

	@RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
		verifyPoll(pollId);
	_pollRepository.delete(pollId);
	
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
		
}
