package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;




@Controller
public class SongsController {
	@Autowired
	SongService sserv;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song)
	{
		
		
		boolean songstatus=sserv.nameExist(song.getName());
		if(songstatus == false)
		{
			sserv.addSongs(song);
			return "demo";
		}else
		{
			return "songfail";
		}
	}
	
	@GetMapping("/view-Songs")
	public String viewSongs(Model model) {
		List<Song> slist=sserv.viewSongs();
		model.addAttribute("songs",slist);
		return "songview";
	}
	
	@GetMapping("/view-Songs1")
	public String viewSongsra(Model model) {
		List<Song> slist=sserv.viewSongs();
		model.addAttribute("songs",slist);
		return "songview2";
	}
	@GetMapping("/view-Songscustomer")
	public String viewSongs1(Model model) {
		
		boolean primeStatus=false;
		if(primeStatus == true)
		{
		List<Song> slist=sserv.viewSongs();
		model.addAttribute("songs",slist);
		return "songview";
		}
		else
		{
			return"makepayment";
		}
	}

}
