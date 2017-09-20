package com.demo.org.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.org.bean.Account;
import com.demo.org.mapper.IAccountService;
import com.demo.org.service.IAccount;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Resource
	private IAccount accountService;
	
	@Resource
	private IAccountService iac;
	
	@RequestMapping()
	public String index(ModelMap resultMap) {
		
		List<Account> accountList = iac.getAll();//accountService.getCount();
		resultMap.addAttribute("account",accountList.get(1));
		
		return "index";
	}
}
