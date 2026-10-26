package com.example.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class userLoginDto {

	@NotBlank(message = "username cannot be null or empty")
	private String userName;

	@NotBlank(message = "password cannot be null or empty")
	@Schema(description = "userName", example = "userName cannot be empty")
	
	private String password;

}
