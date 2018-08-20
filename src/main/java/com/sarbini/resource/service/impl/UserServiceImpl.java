package com.sarbini.resource.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarbini.resource.domain.User;
import com.sarbini.resource.repository.UserRepository;
import com.sarbini.resource.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	public User findByUserName(String name) {
		return userRepository.findByUsername(name).isPresent() ? userRepository.findByUsername(name).get(): null ;
	}

	public void saveUser(User user) {
		user.setPassword("123456");
		userRepository.save(user);
	}

	public void updateUser(User user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.deleteById(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByUserName(user.getUsername()) != null;
	}
}
