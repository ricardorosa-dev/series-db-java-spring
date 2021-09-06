package com.DbRelations.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DbRelations.Entities.Actor;
import com.DbRelations.Repository.ActorRepository;

@RestController
@RequestMapping("/actors")
public class ActorController {
	
	private final ActorRepository actorRepository;
	
	@Autowired
	public ActorController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
	@GetMapping
	public List<Actor> getActors() {
		return actorRepository.findAll();
	}
	
	@PostMapping
	public List<Actor> addActor(@RequestBody final Actor actor) {
		actorRepository.save(actor);
		
		return actorRepository.findAll();
	}

}
