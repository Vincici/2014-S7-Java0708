package com.demo.org.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//do something
		
		/*Connection con = null;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//数据库uri
			String dburl = "jdbc:mysql://localhost/java0708s7?"
					+ "user=j0708s7&password=j0708s7";
			//获取连接
			con = DriverManager.getConnection(dburl);
			
			Statement stat = con.createStatement();
			//执行查询语句
			ResultSet rs = stat.executeQuery("select count(1) cnt from demo");
			//获取结果
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				request.setAttribute("cnt", cnt);
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
		
		*/
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
