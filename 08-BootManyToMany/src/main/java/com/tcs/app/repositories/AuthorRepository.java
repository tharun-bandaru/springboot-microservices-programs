package com.tcs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.app.entities.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

}
