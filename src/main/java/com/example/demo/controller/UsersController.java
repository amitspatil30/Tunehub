package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	// This below method is used check the form is working condtion without creating
	// the entity class

//	@PostMapping("/register")
//	public String addUser(@RequestParam String username,
//			@RequestParam String email,
//			@RequestParam String password, 
//			@RequestParam String gender, 
//			@RequestParam String role, 
//			@RequestParam String address)
//	{
//		System.out.println(username+" "+email+" "+password+" "+gender+" "+role+" "+address);
//		return null;
//	}

	@Autowired
	UsersService userv;
	@Autowired
	SongService sserv;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		boolean usersstatus = userv.emailExists(user.getEmail());
		if (usersstatus == false) {
			userv.addUser(user);
			return "registersucess";
		} else {
			return "registerfail";
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session) //public String validateUser(@RequestParam String email, @RequestParam String password)
	{
		
		
		boolean loginstatus = userv.validateUser(email, password);

		if (loginstatus == true) {
			session.setAttribute("email", email);
			if (userv.getRole(email).equals("admin")) {
				return "adminhome";
			} else {
				return "customerhome";
			}
		} else {
			return "loginfail";
		}
	}
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model)                       //public String exploreSongs(String email)
	{
		String email=(String) session.getAttribute("email");
		Users user=userv.getUser(email);
		
		boolean userStatus=user.isPremium();
		if(userStatus==true)
		{
		List<Song> slist=sserv.viewSongs();
      	model.addAttribute("songs",slist);
			return"premiumuser";
		}else
		{
			return"samplepayment";
		}
	}

}
