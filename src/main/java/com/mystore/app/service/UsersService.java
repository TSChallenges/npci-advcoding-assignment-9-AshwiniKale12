package com.mystore.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mystore.app.entity.Users;
import com.mystore.app.repositories.UsersRepository;

@Service
public class UsersService implements UserDetailsService{

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Users careateUsers(Users users) {
	    if (users.getPassword() == null || users.getPassword().isEmpty()) {
	        throw new IllegalArgumentException("Password cannot be null or empty");
	    }
	    
	    String encryptedPassword = passwordEncoder.encode(users.getPassword());
	    users.setPassword(encryptedPassword);
	    Users user = usersRepository.save(users);
	    return user;
	}

	
	public Users getUserByName(String username) {
		Users user = usersRepository.findByUsername(username);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getUserByName(username);
	}
	
	

}
