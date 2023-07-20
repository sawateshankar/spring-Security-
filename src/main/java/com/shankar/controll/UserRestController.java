package com.shankar.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	@GetMapping("/")
	public String welcome()
	{
		return "welcome to login ";
	}
	
	@GetMapping("/admin")
	public String adminProcess()
	{
		return "welcome to admin role ";
	}
	@GetMapping("/user")
	public String userProcess()
	{
		return "welcome to user role";
	}

}
