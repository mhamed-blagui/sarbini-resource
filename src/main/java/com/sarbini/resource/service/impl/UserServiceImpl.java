package com.sarbini.resource.service.impl;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sarbini.resource.domain.Authority;
import com.sarbini.resource.domain.User;
import com.sarbini.resource.model.UserData;
import com.sarbini.resource.repository.AuthorityRepository;
import com.sarbini.resource.repository.UserRepository;
import com.sarbini.resource.service.UserService;
import com.sarbini.resource.util.RandomUtil;

@Component
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User createUser(UserData userDTO) {
		User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setImageUrl(userDTO.getImageUrl());
        if (userDTO.getLangKey() == null) {
            user.setLangKey("en"); // default language
        } else {
            user.setLangKey(userDTO.getLangKey());
        }
        if (userDTO.getAuthorities() != null) {
            Set<Authority> authorities = new HashSet<>();
            userDTO.getAuthorities().forEach(
                authority -> authorities.add(authorityRepository.findOne(authority))
            );
            user.setAuthorities(authorities);
        }
        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(Instant.now());
        user.setActivated(true);
        userRepository.save(user);
        log.debug("Created Information for User: {}", user);
        return user;
	}
	
	@Override
	public void deleteUser(String login) {
        userRepository.findOneByLogin(login).ifPresent(user -> {
            userRepository.delete(user);
            log.debug("Deleted User: {}", user);
        });
    }
}
