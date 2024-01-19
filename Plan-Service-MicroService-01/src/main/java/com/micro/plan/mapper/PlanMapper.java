package com.micro.plan.mapper;

import org.springframework.beans.BeanUtils;

import com.micro.plan.dto.PlanDto;
import com.micro.plan.entity.PlanEntity;

public class PlanMapper {

	public static PlanDto mapPlanEntityToPlanDto(PlanEntity entity) {
		
		PlanDto planDto= new PlanDto();
		BeanUtils.copyProperties(entity, planDto);
		return planDto;
	}
}
