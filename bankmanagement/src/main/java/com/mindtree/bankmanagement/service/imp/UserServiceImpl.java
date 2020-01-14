package com.mindtree.bankmanagement.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bankmanagement.dto.UserDto;
import com.mindtree.bankmanagement.entity.User;
import com.mindtree.bankmanagement.repository.UserRepository;
import com.mindtree.bankmanagement.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public String addUser(UserDto userDto) {

		User user=modelMapper.map(userDto, User.class);
		userRepository.save(user);
		
		return "User Added Successfully....";
	}


	@Override
	public List<UserDto> getAllUsers() {
	
		List<User> users=userRepository.findAll();
		List<UserDto> userDtos=new ArrayList<UserDto>();
		
		users.forEach(e ->{
			UserDto userDto=modelMapper.map(e,UserDto.class);
			userDtos.add(userDto);
		});
		
		return userDtos;
	}

}
