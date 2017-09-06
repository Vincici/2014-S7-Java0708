package com.demo.org.dao;

import java.util.Set;

import com.demo.org.bean.Account;

public interface AccountDao {
	public int getAccountId(Account account);
	
	public Set<String> getFunctions(Account account);
}
