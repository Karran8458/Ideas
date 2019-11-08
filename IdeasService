package com.codingdojo.event.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.User;
import com.codingdojo.event.repositories.EventRepository;
@Service
public class EventService {
    // adding the book repository as a dependency
private final EventRepository eventRepository;
    
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    // returns all the books
    public List<Event> allEvents() {
        return eventRepository.findAll();
    }
    // creates a book
    public Event createEvent(Event b) {
        return eventRepository.save(b);
    }
    // retrieves a book
    public Event findEvent(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }
    public void updateEvent(@Valid Event event) {
		eventRepository.save(event);
	}
    public List<Event> findByHost(User host) {
        return eventRepository.findByHost(host);
    }
}



