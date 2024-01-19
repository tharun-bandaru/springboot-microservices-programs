package com.friend.micro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friend.micro.repository.FriendRepository;
import com.friend.micro.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendRepository friendRepo;

	@Override
	public boolean addFriend(Long phoneNo, Long friendNo) {


		int count=friendRepo.getCount(phoneNo, friendNo);
		if(count==1) {
			return false;
		}
		else
		{
			friendRepo.addContact(phoneNo, friendNo);
			return true;
		}
	}

	@Override
	public boolean removeFriend(Long phoneNo, Long friendNo) {

		/*
		 * if the phoneNo and friendNo matched(count=1) then delete friendNo
		 */
		int count=friendRepo.getCount(phoneNo, friendNo);
		if(count==1)
		{
			friendRepo.deleteContact(phoneNo, friendNo);
			return true;
		}
		else
			return false;
	}

	@Override
	public List<Long> viewFriends(Long phoneNo) {
		List<Long> friends=friendRepo.fetchContactsOfFriends(phoneNo);
		return friends;
	}

}
