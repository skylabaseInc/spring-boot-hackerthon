package com.example.demo.contoller;
import com.example.demo.service.UserService;
import com.example.demo.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UserController {

	@Autowired
	private UserService _userService;
	
	@RequestMapping(value="/users",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<UserModel>> getUser(){
		Collection<UserModel> user = new ArrayList<>();
		Collection<UserModel> allUser= _userService.findAll();
		user.addAll(allUser);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/users/{userId}",method=RequestMethod.GET)
	public ResponseEntity<UserModel> getUserById(@PathVariable ("userId") long userId){
		UserModel user = _userService.findById(userId);
		if(user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		}
}
