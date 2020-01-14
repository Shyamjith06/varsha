package com.mindtree.bankmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.bankmanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);

}
