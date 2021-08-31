package com.DbRelations.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = EpisodeJsonDeserializer.class)
public class Episode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(name = "episode_number", nullable = true)
	private int episodeNumber;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private String summary;
	
	@ManyToOne(
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "series_id",
			referencedColumnName = "id",	
			nullable = false
	)
	@JsonIgnoreProperties(value = {"episodes"})
	private Series seriesId;

}
