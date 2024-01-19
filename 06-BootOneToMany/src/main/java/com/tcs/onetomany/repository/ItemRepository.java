package com.tcs.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.onetomany.entities.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
