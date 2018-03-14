package com.sarbini.resource.service;

import com.sarbini.resource.domain.User;
import com.sarbini.resource.model.UserData;

public interface UserService {

	public User createUser(UserData userDTO);
	
	public void deleteUser(String login);
}
