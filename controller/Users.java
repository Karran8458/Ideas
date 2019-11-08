package com.codingdojo.event.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.event.models.User;
import com.codingdojo.event.services.UserService;
import com.codingdojo.event.validator.UserValidator;

//imports removed for brevity
@Controller
public class Users {
 private final UserService userService;
 private final UserValidator userValidator;
 private int count = 2;
 public Users(UserService userService, UserValidator userValidator) {
    this.userValidator = userValidator;
	this.userService = userService;
 }
 @RequestMapping("/")
 public String index(@ModelAttribute("user") User user) {
     return "index.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 userValidator.validate(user, result);
     if(result.hasErrors()) {
         return "index.jsp";
     }
     User u = userService.registerUser(user);
     session.setAttribute("userId", u.getId());
     setCount(getCount() + 1);
     return "redirect:/event";
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
     boolean isAuthenticated = userService.authenticateUser(email, password);
     System.out.println(email+" "+ password);
     System.out.println(isAuthenticated);
     if (isAuthenticated) {
    	 User u = userService.findByEmail(email);
         session.setAttribute("userId", u.getId());
         return "redirect:/event";
     } else {
    	 model.addAttribute("error", "Invalid Credentials. Please try again.");
    	 return "redirect:/";
     }
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     session.invalidate();
     return "redirect:/";
 }
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
}

