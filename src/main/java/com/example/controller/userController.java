package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.responceMessage;
import com.example.Dto.userLoginDto;
import com.example.Dto.userRegisterdto;
import com.example.service.registerUserService;
import com.example.utility.constant;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class userController {
	
	private final registerUserService service;
	
	@PostMapping("/Register")
	public ResponseEntity<?> UserRegister(@Valid @RequestBody userRegisterdto dto) {
		
		service.register(dto);
		return ResponseEntity.ok(new responceMessage(201,constant.success, "user created successfully"));
	}
	
	@PostMapping("/login")
	public ResponseEntity<responceMessage> loginApi(@Valid @RequestBody userLoginDto dto) {
		service.login(dto);
		return ResponseEntity.ok(new responceMessage(200,constant.success, "login successfully"));
	}
	
	
}
	

