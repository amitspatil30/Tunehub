package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.PlayList;

public interface PlayListService 
{
	public String addPlayList(PlayList playlist);

	public List<PlayList> viewPlayList();

	public void deletePlaylistById(int id);

}
