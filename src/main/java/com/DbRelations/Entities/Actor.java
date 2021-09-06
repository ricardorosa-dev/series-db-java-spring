package com.DbRelations.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = ActorJsonDeserializer.class)
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private int activeSince;
	
	// Owner
	@ManyToMany
	@JoinTable(
			name = "actor_series",
			joinColumns = @JoinColumn(name = "actor_id"),
			inverseJoinColumns = @JoinColumn(name = "series_id")
	)
	@JsonIgnoreProperties(value = "actors")
	private List<Series> series = new ArrayList<>();
	
//	@OneToOne
//	@JoinColumn(
//			name = "series_id", 
//			referencedColumnName = "id",
//			nullable = true)
//	@JsonIgnoreProperties(value = {"actor"})
//	private Series seriesId;
	
	
	public void addSeries(Series incomingSeries) {
		series.add(incomingSeries);
	}

}
