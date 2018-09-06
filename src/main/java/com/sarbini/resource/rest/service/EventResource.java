package com.sarbini.resource.rest.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarbini.resource.domain.Event;
import com.sarbini.resource.service.EventService;

@RestController
@RequestMapping("/api")
public class EventResource {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/event/", method = GET)
	public ResponseEntity<List<Event>> findAllEvents() {
		List<Event> events = eventService.findAllEvents();
		if (events.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
}
