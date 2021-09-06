package com.DbRelations.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DbRelations.Entities.Soundtrack;
import com.DbRelations.Entities.SoundtrackProjection;

@Repository
public interface SoundtrackRepository extends JpaRepository<Soundtrack, Integer> {
	
	@Query("SELECT s FROM Soundtrack s")
	List<SoundtrackProjection> getAllSoundtracks();

}
