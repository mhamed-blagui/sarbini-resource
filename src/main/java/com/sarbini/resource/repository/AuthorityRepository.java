package com.sarbini.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbini.resource.domain.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String>{

}
