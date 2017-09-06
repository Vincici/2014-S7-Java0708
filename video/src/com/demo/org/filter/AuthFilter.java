package com.demo.org.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.demo.org.bean.Account;
import com.demo.org.dao.AccountDao;
import com.demo.org.dao.impl.AccountDaoImpl;

/**
 * Servlet Filter implementation class AuthFilter
 */

@WebFilter(filterName = "F1_AuthFilter",urlPatterns="/*")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
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
		
		//获取当前登录的账户信息
		HttpServletRequest hsr = (HttpServletRequest)request;
		String username =(String)hsr.getSession().getAttribute("username");
		int id = 0;
		if(hsr.getSession().getAttribute("user_id")!=null) {
			id = (int)hsr.getSession().getAttribute("user_id");
		}
		
		//获取该账户的权限信息
		AccountDao ad = new AccountDaoImpl();
		Account account = new Account();
		account.setId(id);
		account.setUsername(username);
		Set<String> functionSet = ad.getFunctions(account);
		//获取当前url是否在权限内
		String url = hsr.getServletPath();
		
		//if(在权限内) 往后执行
		//else 跳到无权限页面
		if(functionSet.contains(url)) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else {
			//跳转到无权限页面
			request.getRequestDispatcher("/WEB-INF/jsp/noauth.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
