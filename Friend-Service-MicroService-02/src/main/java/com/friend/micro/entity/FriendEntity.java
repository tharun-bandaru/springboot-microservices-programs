package com.friend.micro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="FRIEND")
@Data
public class FriendEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
	private Long phoneNo;
	private Long friendNo;
	
}
