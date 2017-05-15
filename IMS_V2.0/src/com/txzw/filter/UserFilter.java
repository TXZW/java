package com.txzw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/*")
public class UserFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		request2.setCharacterEncoding("utf-8");
		response2.setCharacterEncoding("utf-8");
		String url = request2.getRequestURI();
		request2.getSession().setAttribute("project", request2.getContextPath());
		if (request2.getSession().getAttribute("teacher") != null || url.equals(request2.getContextPath() + "/Login")
				|| url.equals(request2.getContextPath() + "/login.jsp")) {
			// pass the request along the filter chain
			chain.doFilter(request2, response2);
		} else {
			System.out.println("请登录!");
			response2.sendRedirect(request2.getContextPath() + "/login.jsp");
		}
		System.out.println("过滤器===========");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
