package com.demo.org.service.impl;

import org.springframework.stereotype.Service;

import com.demo.org.service.IAccount;

@Service("accountService")
public class AccountImpl implements IAccount{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 123;
	}

}
