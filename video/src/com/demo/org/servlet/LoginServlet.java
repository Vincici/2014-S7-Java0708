package com.demo.org.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String username = request.getParameter("username");
		String pw = request.getParameter("pw");
		
		//数据库验证
		Connection con = null;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//数据库uri
			String dburl = "jdbc:mysql://localhost/java0708s7?"
					+ "user=j0708s7&password=j0708s7";
			//获取连接
			con = DriverManager.getConnection(dburl);
			
			
			//执行查询语句
			String sql = "select count(1) cnt from account where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			//获取结果
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				//如果验证成功
				if(cnt == 1) {
					request.getSession().setAttribute("username", username);
				}
			}
			
			
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
		
		//如果验证失败
		
		
		response.sendRedirect("Index");
		
	}

}
