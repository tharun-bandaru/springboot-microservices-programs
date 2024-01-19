package com.micro.customer.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.customer.dto.PlanDTO;

@FeignClient("PLAN")
public interface PlanProxy {

	@GetMapping("/api/v1/plans/{id}")
	ResponseEntity<PlanDTO> queryPlanData(@PathVariable String id);

	

	
}
