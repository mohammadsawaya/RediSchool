package com.myexperience.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String fnu=user.getFirstName().toUpperCase();
		user.setFirstName(fnu);
		user.setLastName(user.getLastName().toUpperCase());
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY,MM,dd");
		Date datenow=new Date();
		String sd=sdf.format(datenow);

		try {
			user.setRegistredDate(sdf.parse(sd));
		}catch (ParseException e) {
			System.out.println("Unparseable using " +sd);
		}
		return this.userRepository.save(user);
	}
	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}
	public List<User> login(String userName,String passWord) {
		boolean un=userRepository.findByUserNameLike(userName);
		boolean pas=userRepository.findByPassWordLike(passWord);
		if (un && pas){
			return this.userRepository.findAll();
		}
		else
			return null;

	}
}
