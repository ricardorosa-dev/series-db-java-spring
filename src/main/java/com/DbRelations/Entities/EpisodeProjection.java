package com.DbRelations.Entities;

import org.springframework.beans.factory.annotation.Value;

public interface EpisodeProjection {
	
	int getId();
	int getEpisodeNumber();
	String getName();
	String getSummary();
	int getSeason();
	
	@Value("#{target.seriesId.id}")
	int getSeriesId();

}
