package com.sarbini.resource.service;

import java.util.List;

import com.sarbini.resource.domain.User;
import com.sarbini.resource.model.UserData;

public interface UserService {

	public User createUser(UserData userDTO);
	
	public void deleteUser(String login);

<<<<<<< HEAD
	public UserData findUserById(long id);

	public List<UserData> findAllUsers();

=======
	public List<UserData> findAllUsers();

	public UserData findUserById(long id);

>>>>>>> a6b70b90701afdd37858507902f103a21c201c73
	public boolean isUserExist(UserData user);
}
