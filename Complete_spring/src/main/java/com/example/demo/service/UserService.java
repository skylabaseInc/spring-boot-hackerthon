package com.example.demo.service;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.UserModel;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
@Secured("ROLE_ADMINISTRATION")
public class UserService {

	
	@Autowired
	private UserRepository _userRepository;
	
	public Collection<UserModel> findAll(){
		Collection<UserModel> user =(Collection<UserModel>) _userRepository.findAll();
		return user;
	}
	
	public UserModel findById(Long id ) {
		UserModel user = _userRepository.findOne(id);
		return user;
	}
	
	public UserModel findByEmail(String email) {
		UserModel user =_userRepository.findByEmail(email);
		return user;
	}
	
	public UserModel create (UserModel user) {
		if(user.getEmail()!=null) {
			UserModel savedUser = _userRepository.save(user);
			return savedUser;
		}
		return null;
	}
	
	public UserModel update(UserModel user) {
		UserModel savedUser = _userRepository.save(user);
		return savedUser;
	}
	
}
