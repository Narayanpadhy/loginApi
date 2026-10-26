package com.example.exception;

public class userAlreadyExist extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public userAlreadyExist(String msg) {
		super(msg);
	}
}
