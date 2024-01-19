package com.tcs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.app.entities.PassportEntiy;

public interface PassportRepository extends JpaRepository<PassportEntiy, Integer> {

}
