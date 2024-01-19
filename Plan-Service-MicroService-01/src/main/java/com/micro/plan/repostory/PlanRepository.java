package com.micro.plan.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.plan.entity.PlanEntity;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, String> {

}
