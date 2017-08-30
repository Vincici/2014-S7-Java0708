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
		
		//���ݿ���֤
		Connection con = null;
		try{
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�uri
			String dburl = "jdbc:mysql://localhost/java0708s7?"
					+ "user=j0708s7&password=j0708s7";
			//��ȡ����
			con = DriverManager.getConnection(dburl);
			
			
			//ִ�в�ѯ���
			String sql = "select count(1) cnt from account where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			//��ȡ���
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				//�����֤�ɹ�
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
		
		//�����֤ʧ��
		
		
		response.sendRedirect("Index");
		
	}

}
