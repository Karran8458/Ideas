package com.codingdojo.event.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.User;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
    // this method retrieves all the books from the database
    List<Event> findAll();
	List<Event> findByHost(User host);
}

