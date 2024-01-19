package com.micro.customer.api.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FRIEND")
public interface FriendProxy {


	@GetMapping("/api/v1/friend/view-all/{phoneNo}")
	ResponseEntity<List<Long>> queryFriendsContacts(@PathVariable Long phoneNo);
	

}
