package com.sarbini.resource.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sarbini.resource.dto.UserDTO;
import com.sarbini.resource.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/createUser")
    public String createUser(@RequestParam(value="login", defaultValue="admin") String login) {
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin(login);
		userService.createUser(userDTO);
        return "OK";
    }
}
