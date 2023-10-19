package com.ticketTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ticketTracker.dto.RegistrationDto;
import com.ticketTracker.entity.User;
import com.ticketTracker.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	
	private UserService userService;
	public AuthController(UserService userService) {
		this.userService = userService;
		}
	
	//handller method to handle login request
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	//handller user registration page
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		
		RegistrationDto user = new RegistrationDto();
		model.addAttribute("user", user);
		return "register";
	}
	
	@PostMapping("/register/save")
	public String register(@Valid @ModelAttribute("user") RegistrationDto user,BindingResult result, Model model) {
		User existingUser = userService.findByEmail(user.getEmail());
		if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", "There is already a user with email address");
		}
		if(result.hasErrors()) {
			model.addAttribute("user",user);
			return "register";
		}
		userService.saveUser(user);
		return "redirect:/register?success";
	}
	
	
}
