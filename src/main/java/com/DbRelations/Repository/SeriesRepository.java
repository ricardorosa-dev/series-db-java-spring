package com.DbRelations.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DbRelations.Entities.Series;
import com.DbRelations.Entities.SeriesProjection;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {
	
	@Query("SELECT s FROM Series s")
	List<SeriesProjection> getAllSeries();

}
