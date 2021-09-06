package com.DbRelations.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DbRelations.Entities.Series;
import com.DbRelations.Entities.SeriesProjection;
import com.DbRelations.Repository.SeriesRepository;

@RestController
@RequestMapping("/series")
public class SeriesController {
	
	private final SeriesRepository seriesRepository;
	
	@Autowired
	public SeriesController(SeriesRepository seriesRepository) {
		this.seriesRepository = seriesRepository;
	}
	
	@GetMapping
	public List<SeriesProjection> getAllSeries() {
		return seriesRepository.getAllSeries();
	}
//	public List<Series> getSeries() {
//		return seriesRepository.findAll();
//	}
	
	@GetMapping(path = "{seriesId}")
	public Optional<Series> getSeriesById(@PathVariable("seriesId") int id) {
		Optional<Series> series = seriesRepository.findById(id);
		
		return series;
	}
	
	@PostMapping
	public List<Series> addSeries(@RequestBody final Series series) {
//		System.out.println(series.getReleaseDate());
		seriesRepository.save(series);
		
		return seriesRepository.findAll();
	}
	
	@DeleteMapping(path = "{seriesIdParam}")
	public void delSeries(@PathVariable("seriesIdParam") int seriesId) {
		boolean exists = seriesRepository.existsById(seriesId);
		if(!exists) {
			throw new IllegalStateException(
					"The series with id " + seriesId + " doesn't exist." 
			);
		}
		seriesRepository.deleteById(seriesId);
	}

}
