package com.demo.org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection() throws SQLException{
		//数据库连接信息
		String dburl = "jdbc:mysql://localhost/java0708s7?"
				+ "user=j0708s7&password=j0708s7";
		//数据库连接
		return DriverManager.getConnection(dburl);
	}
	//关闭连接
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//执行更新
	public static int executeUpdate(String sql) {
		Connection con = null;
		try{
			con = getConnection();
			
			Statement stat = con.createStatement();
			int result = stat.executeUpdate(sql);
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return 0;
	}
}
