package com.DbRelations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DbRelations.Entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
