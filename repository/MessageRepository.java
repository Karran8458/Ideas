package com.codingdojo.event.repositories;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.Message;
import com.codingdojo.event.models.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

public interface MessageRepository extends CrudRepository<User, Long>{
	Message save(Message m);
}
