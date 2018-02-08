package com.example.controller;
import com.example.domain.Poll;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.repository.PollRepository;

@Controller
@RestController
public class PollController {

	@Autowired
	private PollRepository _pollRepository;
	
	@RequestMapping(value="/polls",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable <Poll>> getAllPolls(){
		Iterable<Poll> AllPolls = _pollRepository.findAll();
		return new ResponseEntity<>(AllPolls,HttpStatus.OK);
		}
		
		//Retreiving all poll
		@RequestMapping(value="/polls", method=RequestMethod.POST)
		public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
		poll = _pollRepository.save(poll);
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollUri = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(poll.getId())
		.toUri();
		responseHeaders.setLocation(newPollUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
		}
		
		//Retreiving an individual poll
		@RequestMapping(value="polls/{PollId}",method = RequestMethod.GET)
		public ResponseEntity<?> getPoll( @PathVariable Long pollId){
			Poll p = _pollRepository.findOne(pollId);
			return new ResponseEntity<>(p,HttpStatus.OK);	
		}
		
		//Update and delete a poll
		@RequestMapping(value ="/polls/{pollId}", method=RequestMethod.PUT)
		public ResponseEntity<?> updatePoll(@RequestBody Poll poll,@PathVariable Long pollId){
			Poll p =_pollRepository.save(poll);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
	
		@RequestMapping(value="polls/{pollId}",method=RequestMethod.DELETE)
		public ResponseEntity<?> deletePoll(@PathVariable Long pollId){
			_pollRepository.delete(pollId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
}
