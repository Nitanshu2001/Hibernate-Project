package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;
import com.repository.UserRepositry;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String root()
	{
		return"index";
	}
	
	
	@Autowired
	UserRepositry userRepository;
	
	//new user jsp
	@GetMapping("newuser")
	public String newUser()
	{
		return "NewUser";
	}
	@PostMapping("saveuser")
	public String saveuser(UserEntity userEntity)  //{read user data from jsp.
	{
		//Validation
		//Success
		//save in database , dao-> replace repository
		userRepository.save(userEntity); // with .save method we can do insert and update query.
		//id not present -> insert
		//id present -> match -> update
		//id present -> no match -> insert
		return"index";
	}
	
	@GetMapping("listuser")
	public String listuser(Model model)
	{
		//select * from users;
		List<UserEntity> users = userRepository.findAll();
		model.addAttribute("users",users);
		return "ListUser";
	}
	@GetMapping("deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int userId) {
	    userRepository.deleteById(userId);
	    return "redirect:/listuser";
	}
	@GetMapping("edituser/{id}")
	public String editUser(@PathVariable("id") int userId,Model model)
	{
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
	        UserEntity user = userOptional.get();
	        model.addAttribute("user", user);
	        return "EditUser";  // Return the view to edit the user
	    } else {
	        // If the user is not found, redirect to the list of users
	        return "redirect:/listuser";
	    }
	}

}
