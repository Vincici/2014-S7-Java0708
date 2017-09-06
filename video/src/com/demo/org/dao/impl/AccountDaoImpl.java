package com.demo.org.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.demo.org.bean.Account;
import com.demo.org.dao.AccountDao;
import com.demo.org.dao.DbDao;
import com.demo.org.util.DbManager;

public class AccountDaoImpl implements DbDao,AccountDao{
	
	public int getAccountId(Account account) {
		
		Connection con = null;
		try{
			con = DbManager.getConnection();
			
			String sql = "select id from account where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				return id;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.closeConnection(con);
		}
		
		return 0;
	}

	public Set<String> getFunctions(Account account){
		Set<String> functionSet = new HashSet<>();
		Connection con = null;
		try{
			con = DbManager.getConnection();
			
			String sql = "select f.url furl from account acc , account_role ar ," + 
					"role_function rf,function f " + 
					"where acc.id = ar.account_id " + 
					"and ar.role_id = rf.role_id and rf.function_id=f.id " + 
					"and acc.id = " + account.getId();
			Statement state = con.createStatement();
			
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				functionSet.add(rs.getString("furl"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.closeConnection(con);
		}
		
		return functionSet;
	}
	
	@Override
	public int insertData(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
}
