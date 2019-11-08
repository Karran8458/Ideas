package com.codingdojo.event.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.Message;
import com.codingdojo.event.models.User;
import com.codingdojo.event.repositories.EventRepository;
import com.codingdojo.event.repositories.MessageRepository;
import com.codingdojo.event.repositories.UserRepository;

public class MessageService {
private final MessageRepository messageRepository;
    
public MessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
}
public Message createMessage(Message m) {
    return messageRepository.save(m);
}
}
