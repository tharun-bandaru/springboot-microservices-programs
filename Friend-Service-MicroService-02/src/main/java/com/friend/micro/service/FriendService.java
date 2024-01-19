package com.friend.micro.service;

import java.util.List;

public interface FriendService {

	boolean addFriend(Long phoneNo,Long friendNo);
	
	boolean removeFriend(Long phoneNo,Long friendNo);
	
	List<Long> viewFriends(Long phoneNo);
}
