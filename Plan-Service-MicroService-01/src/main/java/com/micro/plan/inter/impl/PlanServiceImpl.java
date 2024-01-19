package com.micro.plan.inter.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.plan.dto.PlanDto;
import com.micro.plan.entity.PlanEntity;
import com.micro.plan.inter.PlanServiceInter;
import com.micro.plan.mapper.PlanMapper;
import com.micro.plan.repostory.PlanRepository;

@Service
public class PlanServiceImpl implements PlanServiceInter {

	@Autowired
	PlanRepository planRepository;

	@Override
	public PlanDto fetchPlanData(String planId) {

		Optional<PlanEntity> opt=planRepository.findById(planId);
		if(opt.isPresent())
		{
			return PlanMapper.mapPlanEntityToPlanDto(opt.get());
		}
		else
			return null;
	}

	@Override
	public List<PlanDto> fetchPlans() {
		List<PlanDto> planDto = new ArrayList<>();
		List<PlanEntity> planEntity= planRepository.findAll();
		if(planEntity.size()>0)
		{
			planEntity.forEach(entity->{
				planDto.add(PlanMapper.mapPlanEntityToPlanDto(entity));
			});
			return planDto;
		}
		else
		   return null;
	}

}
