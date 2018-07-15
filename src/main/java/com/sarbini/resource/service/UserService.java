package com.sarbini.resource.service;

import java.util.List;

import com.sarbini.resource.domain.User;
import com.sarbini.resource.model.UserData;

public interface UserService {

	public User createUser(UserData userDTO);
	
	public void deleteUser(String login);

	public List<UserData> findAllUsers();

	public UserData findUserById(long id);

	public boolean isUserExist(UserData user);
}
