package com.codingdojo.event.controllers;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.Message;
import com.codingdojo.event.models.User;
import com.codingdojo.event.services.UserService;
import com.codingdojo.event.validator.UserValidator;
import com.codingdojo.event.services.EventService;
import com.codingdojo.event.services.MessageService;
public class MessageController {
private final MessageService messageService;
    
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @RequestMapping(value="/message", method=RequestMethod.POST)
    public String message(@Valid @ModelAttribute("message") Message message, Model model, @RequestParam("title") String title, @RequestParam("text") String text, @RequestParam("sender") User sender, HttpSession session, BindingResult result) {
    	if (result.hasErrors()) {
            return "/event/new.jsp";
        } else {
        	messageService.createMessage(message);
            return "index.jsp";
        }
    }
}
