package com.mindtree.bankmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.bankmanagement.dto.BankDto;
import com.mindtree.bankmanagement.dto.UserDto;
import com.mindtree.bankmanagement.exception.ServiceException;
import com.mindtree.bankmanagement.service.BankService;
import com.mindtree.bankmanagement.service.UserService;

@Controller
public class BankServiceAppController {
	
	@Autowired
	BankService bankService;
	
	@Autowired
	UserService userService;
	
	ModelAndView modelAndView =new ModelAndView();
	
	@GetMapping("/")
	public ModelAndView index() 
	{
		modelAndView.setViewName("first");
		return modelAndView;
	}
	
    @RequestMapping("/callback")
    public String callback() {
        System.out.println("redirecting to home page");
        return "/index";
    }

	
	@GetMapping("/addbankpage")
	public ModelAndView addBankPage()
	{
		modelAndView.setViewName("addbank");
		return modelAndView;
	}
	@PostMapping("/addbank")
	public ModelAndView addBank(BankDto bankDto) throws ServiceException
	{
		
		String message=bankService.addBank(bankDto);
		
		modelAndView.addObject("status",message);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	@GetMapping("adduserpage")
	public ModelAndView addUserPage()
	{
		modelAndView.setViewName("adduser");
		return modelAndView;
	}
	@PostMapping("/adduser")
	public ModelAndView addUser(UserDto userDto) 
	{
		String message=userService.addUser(userDto);
		modelAndView.addObject("status",message);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	@GetMapping("/linkpage")
	public ModelAndView linkPage()
	{
		List<BankDto> banks=bankService.getAllBanks();
		List<UserDto> users=userService.getAllUsers();
		modelAndView.addObject("users", users);
		modelAndView.addObject("banks", banks);
		
		modelAndView.setViewName("linkuser");
		return modelAndView;	
	}
	@PostMapping("/link")
	public ModelAndView link(@RequestParam String userName, @RequestParam String bankName)
	{
		
		String message=bankService.link(userName,bankName);
		modelAndView.addObject("status",message);
		modelAndView.setViewName("success");
		
		return modelAndView;
	}
	@GetMapping("/viewdtails")
	public ModelAndView viewDetails()
	{
		List<BankDto> banks=bankService.viewBanks();
		modelAndView.addObject("banks", banks);
		modelAndView.setViewName("viewbanks");
		return modelAndView;
	}
	@GetMapping("/deletepage")
	public ModelAndView deletebank()
	{
		modelAndView.setViewName("delete");
		return modelAndView;
	}
	
	@PostMapping("/deleteuser")
	public ModelAndView delete(@RequestParam int userId) throws ServiceException
	{
		String message=bankService.delete(userId);
		modelAndView.addObject("status",message);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
}
