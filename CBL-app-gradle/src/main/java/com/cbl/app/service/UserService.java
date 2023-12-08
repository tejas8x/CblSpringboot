package com.cbl.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cbl.app.models.User;

public interface UserService {
	 User save(User user);
	    Optional<User> findByUsername(String username);
		List<User> getAllUsers();
}
