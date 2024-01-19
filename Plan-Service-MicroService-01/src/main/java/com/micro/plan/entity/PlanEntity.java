package com.micro.plan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PLANS")
@Data
public class PlanEntity {

	@Id
	private String planId;
	private String planName;
	private String validity;
	private String description;
}
