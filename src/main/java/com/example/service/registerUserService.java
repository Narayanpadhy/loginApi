package com.example.service;

import com.example.Dto.userLoginDto;
import com.example.Dto.userRegisterdto;

public interface registerUserService {

	void register(userRegisterdto dto);

	void login(userLoginDto dto);

}
