package com.zylear.plain.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class PlainFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("PlainFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
