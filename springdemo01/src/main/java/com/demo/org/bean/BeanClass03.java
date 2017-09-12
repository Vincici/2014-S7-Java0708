package com.demo.org.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("bc03")
@Scope("prototype")
public class BeanClass03 {
	@Autowired
	private BeanClass02 bc02;
	
	public void showMsg() {
		bc02.showInfo();
	}
}
