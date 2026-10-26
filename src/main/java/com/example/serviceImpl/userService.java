package com.example.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Dto.userLoginDto;  
import com.example.Dto.userRegisterdto;
import com.example.entity.user;
import com.example.exception.userAlreadyExist;
import com.example.repo.userRepo;
import com.example.service.registerUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userService implements registerUserService{

	private final userRepo repo;
	private final PasswordEncoder passwordEncoder;
	
	private static final Logger logger=LoggerFactory.getLogger(userService.class);
	
	@Override
	public void register(@Valid userRegisterdto dto) {
		user use=new user();
		logger.info("registration started :"+dto.getName());
		
		if(repo.existsByUserName(dto.getUserName()))
		{
			throw new userAlreadyExist("user already exist");
		}
		use.setName(dto.getName());
		use.setAge(dto.getAge());
		use.setUserName(dto.getUserName());
		use.setPassword(passwordEncoder.encode(dto.getPassword()));
		repo.save(use);
		logger.info("user created successfully :"+dto.getName());
	}

	@Override
	public void login(userLoginDto dto) {
		user us = repo.findByUserName(dto.getUserName())
				.orElseThrow(() -> new BadCredentialsException("Invalid Username or Password"));
		logger.info("User found");		
		if(!passwordEncoder.matches(dto.getPassword(),us.getPassword()))
		{
		    throw new BadCredentialsException("Invalid Username or Password");
	    }

		logger.info("login successfully");
		}
	}
