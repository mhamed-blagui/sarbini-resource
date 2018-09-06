package com.sarbini.resource.service;

import java.util.List;

import com.sarbini.resource.domain.User;

public interface UserService {

	User findById(Long id);

	User findByUserName(String name);

	User saveUser(User user);

	User updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);
}
