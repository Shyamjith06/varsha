package com.mindtree.bankmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.bankmanagement.dto.BankDto;
import com.mindtree.bankmanagement.dto.UserDto;
import com.mindtree.bankmanagement.exception.ServiceException;

@Service
public interface BankService {

	public String addBank(BankDto bankDto) throws ServiceException;

	public List<BankDto> getAllBanks();

	public String link(String userName, String bankName);

	public List<BankDto> viewBanks();

	public String delete(int bankId) throws ServiceException;

	

}
