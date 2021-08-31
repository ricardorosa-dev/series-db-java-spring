package com.DbRelations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DbRelations.Entities.Soundtrack;

@Repository
public interface SoundtrackRepository extends JpaRepository<Soundtrack, Integer> {

}
