package com.demo.org.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.org.service.IAccount;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Resource
	private IAccount accountService;
	
	@RequestMapping()
	public String index(ModelMap resultMap) {
		
		int count = accountService.getCount();
		resultMap.addAttribute("count",count);
		
		return "index";
	}
}
