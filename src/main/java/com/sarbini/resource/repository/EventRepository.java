package com.sarbini.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbini.resource.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String>{

}
