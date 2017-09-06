package com.demo.org.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.demo.org.bean.Log;
import com.demo.org.dao.DbDao;

public class LogDaoImpl implements DbDao {

	@Override
	public int insertData(Object obj) {
		// TODO Auto-generated method stub
		
		Log log = (Log)obj;
		
		Connection con = null;
		try{
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�uri
			String dburl = "jdbc:mysql://localhost/java0708s7?"
					+ "user=j0708s7&password=j0708s7";
			//��ȡ����
			con = DriverManager.getConnection(dburl);
			
			Statement stat = con.createStatement();
			//ִ�в�ѯ���
			String sqlStr = "insert into user_log(description,account_id)" + 
					" values ('"+log.getDescription()+"',"+log.getAccount_id()+")";
			int result = stat.executeUpdate(sqlStr);
			return result;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}

}
