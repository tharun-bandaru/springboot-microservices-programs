package com.micro.plan.inter;

import java.util.List;

import com.micro.plan.dto.PlanDto;

public interface PlanServiceInter {

	PlanDto fetchPlanData(String planId);
	List<PlanDto> fetchPlans();
}
