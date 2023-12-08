package com.cbl.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbl.app.models.User;
import com.cbl.app.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;

	 @GetMapping("/list")
	    public String listUsers(Model model) {
	        List<User> userList = userService.getAllUsers();
	        model.addAttribute("userList", userList);
	        return "list"; 
	    }
}
