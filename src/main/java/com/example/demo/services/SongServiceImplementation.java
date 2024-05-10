package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
	SongRepository srepo;

	@Override
	public String addSongs(Song song) {
		srepo.save(song);
		
		return "Songs are saved";
	}

	@Override
	public boolean nameExist(String name) {
	
		if(srepo.findByName(name)== null)
		{
			return false;
		}
		else
		{
		return true;
		}
	}

	@Override
	public List<Song> viewSongs() {
		List<Song> songlist=srepo.findAll();
		return songlist;
	}

	@Override
	public void updateSong(Song song) {
		srepo.save(song);
		// TODO Auto-generated method stub
		
	}

}
