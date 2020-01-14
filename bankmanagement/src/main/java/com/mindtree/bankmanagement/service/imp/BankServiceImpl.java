package com.mindtree.bankmanagement.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bankmanagement.dto.BankDto;

import com.mindtree.bankmanagement.entity.Bank;
import com.mindtree.bankmanagement.entity.User;
import com.mindtree.bankmanagement.exception.ServiceException;
import com.mindtree.bankmanagement.repository.BankRepository;
import com.mindtree.bankmanagement.repository.UserRepository;
import com.mindtree.bankmanagement.service.BankService;





@Service
public class BankServiceImpl implements BankService{

	
	ModelMapper modelMapper=new ModelMapper();
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String addBank(BankDto bankDto) throws ServiceException {
		
		if(bankRepository.findAll().stream().filter(i->i.getBankName().equalsIgnoreCase(bankDto.getBankName())).findAny() != null)
		{
			throw new ServiceException("Bank Already Present");
		}
		else {
			Bank bank=modelMapper.map(bankDto, Bank.class);
			bankRepository.save(bank);
			return "Bank Added Successfully..";
		}
//		
	}

	@Override
	public List<BankDto> getAllBanks() {
		List<Bank> banks=bankRepository.findAll();
		List<BankDto> bankDtos=new ArrayList<BankDto>();
		
		banks.forEach(e->{
			BankDto bankDto=new BankDto();
			bankDto=modelMapper.map(e,BankDto.class);
			bankDtos.add(bankDto);
			});
		return bankDtos;
	}

	@Override
	public String link(String userName, String bankName) {

		Bank bank=bankRepository.findBybankName(bankName);
		
		User user=userRepository.findByUserName(userName);
		user.setBank(bank);
		userRepository.save(user);
		
		
		return "User and Bank linked Successfully..";
	}

	@Override
	public List<BankDto> viewBanks() {
		
		List<Bank> banks=bankRepository.findAll();
		List<BankDto> banksDto=new ArrayList<BankDto>();
		
		for (Bank bank : banks) 
		{
			int  sum=0;
			
			sum = bank.getUsers().stream().reduce(0, (count, value)-> (int)(count+value.getOpeningBalance()),Integer:: sum );

			bank.setBalance(sum);
		
		}

		
		banks.forEach(e-> {
			BankDto bankDto=modelMapper.map(e,BankDto.class);
			banksDto.add(bankDto);
			
		});
		
		return banksDto;
	}

	@Override
	public String delete(int userId) throws ServiceException {
	
		Optional<User> users=userRepository.findById(userId);
		users.orElseThrow(() ->new ServiceException("No Such  User"));
		userRepository.deleteById(userId);
		return "User Deleted SuccessFully..";
	}

	
}
