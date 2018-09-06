package com.sarbini.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarbini.resource.domain.Event;
import com.sarbini.resource.repository.EventRepository;
import com.sarbini.resource.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> findAllEvents() {
		return eventRepository.findAll();
	}

}
