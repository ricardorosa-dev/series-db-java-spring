package com.DbRelations.Entities;

import org.springframework.beans.factory.annotation.Value;

public interface SoundtrackProjection {
	
	int getId();
	String getName();
	String getMusician();
	
	@Value("#{target.seriesId.id}")
	int getSeriesId();
}
