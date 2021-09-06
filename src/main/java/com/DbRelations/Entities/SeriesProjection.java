package com.DbRelations.Entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public interface SeriesProjection {
	
	int getId();
	String getName();
	int getReleaseDate();
	String getStudio();
	byte getNumberOfSeasons();
	
	@Value("#{(target.soundtrack != null ? target.soundtrack.id : null)}")
	Integer getSoundtrackId();
	
	List<EpisodeProjectionOnlyName> getEpisodes();
	
	List<Actor> getActors();

}
