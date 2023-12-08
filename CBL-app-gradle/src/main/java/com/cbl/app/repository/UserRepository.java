package com.cbl.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.app.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 Optional<User> findByUsername(String username);
}
