package com.example.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class userRegisterdto {

	private String name;
	private Integer age;

	@NotBlank(message = "username cannot be empty or null")
	private String userName;

	@NotBlank(message = "Password cannot be null")
	@Schema(description = "userName", example = "userName cannot be empty")
	@Size(min = 8,message = "Password must be at least 8 characters")
	private String password;

}
