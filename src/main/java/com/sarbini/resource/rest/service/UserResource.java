package com.sarbini.resource.rest.service;

import static org.springframework.http.MediaType.APPLICATION_ATOM_XML_VALUE;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sarbini.resource.model.UserData;
import com.sarbini.resource.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

	private final static Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/", method = GET)
	public ResponseEntity<List<UserData>> listAllUsers() {
		List<UserData> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<UserData>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		UserData user = userService.findUserById(id);
		if (user == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserData>(user, HttpStatus.OK);
	}

//	@RequestMapping(value = "/user/", method = POST,consumes = APPLICATION_FORM_URLENCODED_VALUE, produces = {APPLICATION_ATOM_XML_VALUE, APPLICATION_JSON_VALUE})
//	public ResponseEntity<UserData> createUser(@RequestBody UserData user, UriComponentsBuilder ucBuilder) {
//		logger.info("Creating User : {}", user);
//
//		if (userService.isUserExist(user)) {
//			logger.error("Unable to create. A User with name {} already exist", user.getFirstName());
//			return new ResponseEntity(HttpStatus.CONFLICT);
//		}
//		userService.createUser(user);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
//		return new ResponseEntity<UserData>(headers, HttpStatus.CREATED);
//	}
	
	@RequestMapping(value = "/user/", method = POST,consumes = APPLICATION_FORM_URLENCODED_VALUE, produces = {APPLICATION_ATOM_XML_VALUE, APPLICATION_JSON_VALUE})
	public ResponseEntity<UserData> createUser(@RequestBody UserData user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("Unable to create. A User with name {} already exist");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		userService.createUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<UserData>(headers, HttpStatus.CREATED);
	}
    
    // -------------------Create a User-------------------------------------------
    
}
