package com.demo.org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.demo.org.bean.UserLog;

public interface IUserLog {
	@Select("select * from user_log")
	public List<UserLog> getAll();
}
