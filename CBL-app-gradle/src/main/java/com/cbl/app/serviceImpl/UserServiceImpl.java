package com.cbl.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.app.models.User;
import com.cbl.app.repository.UserRepository;
import com.cbl.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	  @Autowired
	    private UserRepository userRepository;

	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

}
