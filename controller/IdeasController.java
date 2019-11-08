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
import com.codingdojo.event.models.User;
import com.codingdojo.event.services.UserService;
import com.codingdojo.event.validator.UserValidator;
import com.codingdojo.event.services.EventService;

@Controller
public class EventController {
    // other methods removed for brevity
private final EventService eventService;
private final UserService userService;

    
    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }
    
    @RequestMapping("/event")
    public String index(@Valid @ModelAttribute("user") User user, Model model,HttpSession session) {
    	Long id = (Long) session.getAttribute("userId");
    	User u = userService.findUserById(id);
    	model.addAttribute("user", u);
    	List<Event> events = eventService.allEvents();
    	List<Event> userevents = eventService.findByHost(u);
        model.addAttribute("events", events);
        model.addAttribute("userevents", userevents);
        return "/event/index.jsp";
    }
    @RequestMapping("/event/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Event event = eventService.findEvent(id);
        model.addAttribute("event", event);
        return "/event/edit.jsp";
    }
    @RequestMapping("/event/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Event event = eventService.findEvent(id);
        model.addAttribute("event", event);
        return "/event/show.jsp";
    }
    @RequestMapping(value="/event/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("event") Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "/event/edit.jsp";
        } else {
            eventService.updateEvent(event);
            return "redirect:/event";
        }
    }
    @RequestMapping("/event/new")
    public String newEvent(@ModelAttribute("event") Event event) {
        return "/event/new.jsp";
    }
    @RequestMapping(value="/event/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("event") Event event, @RequestParam("title") String title, @RequestParam("date") String date, @RequestParam("location") String location, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "/event/new.jsp";
        } else {
        	Event newEvent = eventService.createEvent(event);
        	Long id = (Long) session.getAttribute("userId");
        	User u = userService.findUserById(id);
        	newEvent.setHost(u);
        	eventService.updateEvent(newEvent);
            return "redirect:/event";
        }
    }
}



