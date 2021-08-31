package com.DbRelations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DbRelations.Entities.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

}
