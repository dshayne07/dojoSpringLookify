package com.project.Lookify.services;

import java.util.ArrayList;
import java.util.List;

import com.project.Lookify.models.Song;
import com.project.Lookify.repositories.SongRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SongService {
	private SongRepository sR;
		
	public SongService(SongRepository sR){
		this.sR = sR;
	}

	public void create(Song song){
		sR.save(song);
	}

	public Song find(Long id){
		return (Song) sR.findOne(id);
	}

	public ArrayList<Song> findByArtist(String search){
		return (ArrayList<Song>) sR.findByArtist(search);
	}

	public ArrayList<Song> topTen(){
		return (ArrayList<Song>) sR.topTen();
	}

	public ArrayList<Song> all(){
		return (ArrayList<Song>) sR.findAll();
	}

	public void update(Song song){
		sR.save(song);
	}

	public void destroy(Long id){
		sR.delete(id);
	}
	
	
	// Crud methods to act on services go here.
}
