package com.DbRelations.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Series {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "release_date")
	private int releaseDate;
	
	@Column(nullable = false)
	private String studio;
	
	@Column(name = "number_of_seasons", nullable = true)
	private byte numberOfSeasons;
	
	// Owning side
	@OneToOne(mappedBy = "seriesId")
	@JsonIgnoreProperties(value = {"seriesId"})
	private Soundtrack soundtrack;
	
	@OneToMany(
			mappedBy = "seriesId",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JsonIgnoreProperties(value = {"seriesId"})
	private List<Episode> episodes;
	
	@ManyToMany(
			mappedBy = "series",
			cascade = CascadeType.ALL
	)
	@JsonIgnoreProperties(value = {"seriesId"})
	private List<Actor> actors = new ArrayList<>();
	
//	@OneToOne(mappedBy = "seriesId")
//	@JsonIgnoreProperties(value = {"seriesId"})
//	private Actor actor;
	
		
	public void addActor(Actor incomingActor) {
		actors.add(incomingActor);
	}
}
