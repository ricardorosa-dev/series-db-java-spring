package com.DbRelations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DbRelations.Entities.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {

}
