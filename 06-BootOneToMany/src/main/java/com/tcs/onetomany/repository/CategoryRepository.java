package com.tcs.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.onetomany.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
