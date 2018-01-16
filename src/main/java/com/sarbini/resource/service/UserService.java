package com.sarbini.resource.service;

import com.sarbini.resource.domain.User;
import com.sarbini.resource.dto.UserDTO;

public interface UserService {

	public User createUser(UserDTO userDTO);
	
	public void deleteUser(String login);
}
