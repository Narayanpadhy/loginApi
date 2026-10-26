package com.example.Dto;

import lombok.Data;

@Data
public class responceMessage {

	private Integer statusCode;
	private String status;
	private String message;

	public responceMessage(Integer statusCode, String status, String message) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
	}

}