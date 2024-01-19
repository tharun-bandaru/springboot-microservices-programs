package com.friend.micro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.friend.micro.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {

	/*
	 * get the count combination of both friend & contact records 
	 * 
	 * To check whether the customer friends no is already exists or not
	 */

	@Query(value="SELECT COUNT(*) FROM FRIEND WHERE phone_no=? and friend_no=?",nativeQuery=true)
	int getCount(Long phoneNo, Long friendNo);

	/*
	 * adding customer friend contact using customer phone no and friend contact no 
	 */
	@Query(value="INSERT INTO FRIEND(phone_no,friend_no) values(?,?)",nativeQuery=true)
	@Modifying
	@Transactional
	int addContact(Long phoneNo, Long friendNo);

	/*
	 * delete the friend no using customer phone no
	 */

	@Query(value="DELETE FROM FRIEND WHERE phone_no=? and friend_no=? ",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteContact(Long phoneNo,Long friendNo);

	/*
	 * fetch the customer friends no's using customer phone no
	 */

	@Query(value="SELECT friend_no from friend where phone_no=?",nativeQuery=true)
	List<Long> fetchContactsOfFriends(Long phoneNo);



}
