package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginNapping()
	{
		return "login";
	}
	
	@GetMapping("/map-Songs")
	public String mapSongs()
	{
		return "addsongs";
	}
	
	@GetMapping("/sample")
	public String sample()
	{
		return "samplepayment";
	}
	@GetMapping("/map-logout")
	public String logout()
	{
		return "index";
	}
	@GetMapping("/already")
	public String alreg()
	{
		return "login";
	}
	@GetMapping("/map-goback")
	public String back()
	{
		return "adminhome";
	}
	@GetMapping("/map-goback1")
	public String back2()
	{
		return "premiumuser";
	}
	

}
