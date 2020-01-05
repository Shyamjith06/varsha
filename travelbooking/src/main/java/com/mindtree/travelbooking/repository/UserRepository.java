package com.mindtree.travelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.travelbooking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByUserName(String userName);

}
