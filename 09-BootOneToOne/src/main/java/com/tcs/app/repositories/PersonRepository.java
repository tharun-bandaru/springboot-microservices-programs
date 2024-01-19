package com.tcs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.app.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
