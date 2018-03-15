package com.project.Lookify.repositories;

import java.util.ArrayList;
import java.util.List;

import com.project.Lookify.models.Song;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface SongRepository extends CrudRepository<Song,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	@Query(value = "SELECT * FROM song WHERE artist = ?1", nativeQuery = true)
	public ArrayList<Song> findByArtist(String artist);
	  
	@Query(value = "SELECT * FROM song ORDER BY rating DESC LIMIT 10", nativeQuery = true)
	public ArrayList<Song> topTen();
}
