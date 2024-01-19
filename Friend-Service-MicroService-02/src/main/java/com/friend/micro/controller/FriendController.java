package com.friend.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friend.micro.entity.FriendEntity;
import com.friend.micro.service.impl.FriendServiceImpl;

@RestController
@RequestMapping("/api/v1/friend")
public class FriendController {

	@Autowired
	FriendServiceImpl friendServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<String> addContact(@RequestBody FriendEntity friendEntiy)
	{
		boolean addCheck=friendServiceImpl.addFriend(friendEntiy.getPhoneNo(), friendEntiy.getFriendNo());
		if(addCheck)
		{
			return ResponseEntity.ok("friend no saved successfully!!...");
		}
		else {
			return ResponseEntity.ok("friend no is already exists!!...");

		}
	}

	@DeleteMapping("/delete/{phoneNo}/{friendNo}")
	public ResponseEntity<String> deleteContact(@PathVariable Long phoneNo,@PathVariable Long friendNo)
	{
		boolean deleteCheck = friendServiceImpl.removeFriend(phoneNo, friendNo);
		if(deleteCheck)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("friend contact Removed Successfully......");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("friend contact doesn't exists ......");
		}
	}

	@GetMapping("/view-all/{phoneNo}")
	public ResponseEntity<List<Long>> viewContacts(@PathVariable Long phoneNo)
	{
		return ResponseEntity.ok(friendServiceImpl.viewFriends(phoneNo));
	}


}
