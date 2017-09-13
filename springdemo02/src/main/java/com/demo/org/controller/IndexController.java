package com.demo.org.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.org.bean.Student;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping()
	public String index() {
		return "index";
	}
	
	/**
	 * ����ֵ��	@RequestParam
	 * ·��ֵ��	@PathVariable
	 * Rest���ƥ��	/show/{name}
	 * @param namefafda
	 * @param batch
	 * @return
	 */
	@RequestMapping("/show/{name}")
	public String showStudent(@PathVariable("name") String namefafda,String batch,ModelMap resultMap) {
		
		//System.out.println(namefafda+"--"+batch);
		resultMap.addAttribute("name",namefafda);
		resultMap.addAttribute("batch",batch);
		return "index";
	}
	
	@RequestMapping("/show")
	public String showStudent(Student student,ModelMap result) {
		result.addAttribute("student",student);
		return "index";
	}
	
	@RequestMapping("/exception")
	public String showEx() throws Exception{
		
		throw new Exception("showEx");
		//return "index";
	}
	
}
