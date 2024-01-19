package com.micro.plan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.plan.dto.PlanDto;
import com.micro.plan.inter.PlanServiceInter;

@RestController
@RequestMapping("api/v1/plans")
public class PlanApi {

	@Autowired
	PlanServiceInter planService;

	@GetMapping("/{id}")
	public  ResponseEntity<?> getPlanById(@PathVariable String id)
	{
		try {
			PlanDto dto= planService.fetchPlanData(id);
			if(dto!=null)
			{
				return ResponseEntity.ok(dto);
			}
			else {
				throw new Exception("Plan with given id :"+id+" doesn't exist");
			}
		} 
		catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<PlanDto>> getAllPlans()
	{
		List<PlanDto> dto=planService.fetchPlans();
		return ResponseEntity.ok(dto);
	}




}

