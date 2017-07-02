package com.myexperience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myexperience.domain.User;
import com.myexperience.service.UserService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/{version}/myexperience", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController
{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version
			)
	{
		List<User> userList = userService.findAll();
		return new ResponseEntity<>(userList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user, @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
	{
		return userService.add(user);
		
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ResponseEntity<List<User>> logintolist(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "username", defaultValue ="m") @PathVariable("username") String  username,
			@ApiParam(name = "password",defaultValue = "1") @PathVariable("password") String password
	)
	{

		List<User> userList=userService.login(username,password);
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
}
