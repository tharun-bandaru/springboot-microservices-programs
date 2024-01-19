package com.tcs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.app.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
