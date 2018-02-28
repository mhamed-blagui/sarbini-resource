package com.sarbini.resource.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbini.resource.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findOneByLogin(String login);

}
