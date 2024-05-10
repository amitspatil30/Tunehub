package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongService;

@Controller
public class PlayListController {
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongService sserv;
	
	//admin
	@GetMapping("/create-playlist")
	public String createPlayList(Model model)
	{
		List<Song> songslist=sserv.viewSongs();
		model.addAttribute("songslist",songslist);
		return "createplaylist";
	}
	
	//admin
		@GetMapping("/create-playlist1")
		public String createPlayListcustomer(Model model)
		{
			List<Song> songslist=sserv.viewSongs();
			model.addAttribute("songslist",songslist);
			return "createplaylist2";
		}
	
	
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist)
	{
		pserv.addPlayList(playlist);
//	System.out.println(playlist);
		
		List<Song> songList=playlist.getSong();
		System.out.println(songList);
		for(Song song : songList)
		{
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "premiumuser";
		}
	
	
	
	@PostMapping("/addplaylist1")
	public String addPlayListcustomer(@ModelAttribute PlayList playlist)
	{
		pserv.addPlayList(playlist);
//	System.out.println(playlist);
		
		List<Song> songList=playlist.getSong();
		System.out.println(songList);
		for(Song song : songList)
		{
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "premiumuser";
		}
	
	
	
	@GetMapping("/view-playlist")
	public String viewPlayList(Model model)
	{
		List<PlayList> plist=pserv.viewPlayList();
//		System.out.println(plist);
      	model.addAttribute("plist", plist);
		return "viewplaylist";
	}
	@GetMapping("/view-playlist1")
	public String viewPlayListcustomer(Model model)
	{
		List<PlayList> plist=pserv.viewPlayList();
//		System.out.println(plist);
      	model.addAttribute("plist", plist);
		return "viewplaylist2";
	}
	
	 @DeleteMapping("/deletePlaylist/{id}")
	    public String deletePlaylist(@PathVariable("id") int id) {
		 System.out.println(id);
	        pserv.deletePlaylistById(id);
	        return "viewplaylist"; // Redirect to the playlist view page
	    }

}
