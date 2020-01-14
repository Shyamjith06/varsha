package com.mindtree.bankmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.bankmanagement.dto.UserDto;

@Service
public interface UserService {

	public String addUser(UserDto userDto);

	public List<UserDto> getAllUsers();

}
