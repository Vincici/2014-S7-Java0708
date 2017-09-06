package com.demo.org.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.demo.org.bean.Log;
import com.demo.org.dao.DbDao;
import com.demo.org.util.DbManager;

public class LogDaoImpl implements DbDao {

	@Override
	public int insertData(Object obj) {
		// TODO Auto-generated method stub
		
		Log log = (Log)obj;
		
		//ִsql
		String sqlStr = "insert into user_log(description,account_id)" + 
				" values ('"+log.getDescription()+"',"+log.getAccount_id()+")";
		int result = DbManager.executeUpdate(sqlStr);
		
		return 0;
	}

}
