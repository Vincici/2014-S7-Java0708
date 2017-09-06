package com.demo.org.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.demo.org.bean.Log;
import com.demo.org.dao.DbDao;
import com.demo.org.dao.impl.LogDaoImpl;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName = "F0_LogFilter",urlPatterns="/*")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest hsr = (HttpServletRequest)request;
		String url = hsr.getServletPath();
		
		String username = (String)hsr.getSession().getAttribute("username");
		int user_id = 0;
		if(hsr.getSession().getAttribute("user_id") != null) {
			user_id = (int)hsr.getSession().getAttribute("user_id");
		}
		//记录日志信息
		String infoStr = "用户:"+username+",访问url:"+url;
		
		DbDao logDao = new LogDaoImpl();
		Log log = new Log();
		log.setDescription(infoStr);
		log.setAccount_id(user_id);
		
		logDao.insertData(log);
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
