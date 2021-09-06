package com.DbRelations.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DbRelations.Entities.Episode;
import com.DbRelations.Entities.EpisodeProjection;
import com.DbRelations.Entities.EpisodeProjectionOnlyName;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
	
	@Query("SELECT e FROM Episode e")
	List<EpisodeProjection> getAllEpisodes();
	
	@Query("SELECT e FROM Episode e")
	List<EpisodeProjectionOnlyName> getAllEpisodesOnlyName();

}
