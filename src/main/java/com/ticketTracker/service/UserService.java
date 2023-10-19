package com.ticketTracker.service;

import com.ticketTracker.dto.RegistrationDto;
import com.ticketTracker.entity.User;

public interface UserService {
	
	void saveUser(RegistrationDto registrationDto);
	
	User findByEmail (String email);

}
