package com.tcs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.app.entities.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {

}
