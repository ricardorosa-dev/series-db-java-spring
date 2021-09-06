package com.DbRelations.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DbRelations.Entities.Soundtrack;
import com.DbRelations.Entities.SoundtrackProjection;
import com.DbRelations.Repository.SoundtrackRepository;

@RestController
@RequestMapping("/soundtracks")
public class SoundtrackController {
	
	private final SoundtrackRepository repository;
	
	@Autowired
	public SoundtrackController(SoundtrackRepository soundtrackRepository) {
		this.repository = soundtrackRepository;
	}
	
	@GetMapping
	public List<SoundtrackProjection> getAllSoundtracks() {
		return repository.getAllSoundtracks();
	}
//	@GetMapping
//	public List<Soundtrack> getSoundtracks() {
//		return repository.findAll();
//	}
	
	@PostMapping
	public Soundtrack addSoundtrack(@RequestBody final Soundtrack soundtrack) {
//		System.out.println(soundtrack);
		
		return repository.save(soundtrack);
	}

}
