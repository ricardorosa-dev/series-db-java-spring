package com.DbRelations.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DbRelations.Entities.Episode;
import com.DbRelations.Entities.EpisodeProjection;
import com.DbRelations.Repository.EpisodeRepository;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
	
	private final EpisodeRepository episodeRepository;
	
	@Autowired
	public EpisodeController(EpisodeRepository episodeRepository) {
		this.episodeRepository = episodeRepository;
	}
	
	@GetMapping
	public List<EpisodeProjection> getAllEpisodes() {
		
		return episodeRepository.getAllEpisodes();
	}
	
	@PostMapping
	public List<Episode> addEpisode(@RequestBody final Episode episode) {
		episodeRepository.save(episode);
		
		return episodeRepository.findAll();
	}
	
}
