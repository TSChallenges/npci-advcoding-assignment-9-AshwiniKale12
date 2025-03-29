package com.mystore.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystore.app.entity.Users;
import com.mystore.app.service.UsersService;


@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	@GetMapping("/getByName")
	public ResponseEntity<Users> getUsersByName(@PathVariable("username") String username){
		Users user = usersService.getUserByName(username);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Users> createUser(@RequestBody Users user){
		System.out.println(user);
		Users userData = usersService.careateUsers(user);
		return new ResponseEntity<>(userData,HttpStatus.CREATED);
	}
}
