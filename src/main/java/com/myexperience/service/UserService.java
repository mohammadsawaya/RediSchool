package com.myexperience.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexperience.domain.User;
import com.myexperience.repository.UserRepository;


@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public User add(User user)
	{
		return this.userRepository.save(user);
	}
	
	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}
}
