package com.project.Lookify.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.project.Lookify.models.Song;
import com.project.Lookify.services.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class SongController{
	//Member variables go here
	private SongService sS;

	public SongController(SongService sS){
		this.sS = sS;
	}
	
	
	public String dashboard(){
		return "dashboard";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model){
		model.addAttribute("songs", sS.all());
		return "dashboard";
	}

	@RequestMapping("/songs/new")
	public String newSong(Model model){
		model.addAttribute("newSong", new Song());
		return "new";
	}
	
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result){
		if(result.hasErrors())
			return "new";
		else{
			sS.create(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}/delete")
	public String delete(@PathVariable("id") Long id){
		sS.destroy(id);
		return "redirect:/dashboard";
	}

	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model){
		model.addAttribute("song", sS.find(id));
		return "show";
	}

	@RequestMapping("/search/topTen")
	public String topTen(Model model){
		model.addAttribute("songs",sS.topTen());
		return "topTen";
	}

	@RequestMapping("/search**")
	public String search(@RequestParam(value="search") String search, Model model){
		model.addAttribute("songs",sS.findByArtist(search));
		model.addAttribute("search", search);
		return "search";
	}
}
