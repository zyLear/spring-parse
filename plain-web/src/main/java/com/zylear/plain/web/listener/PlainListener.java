package com.zylear.plain.web.listener;

import com.zylear.plain.web.servlet.JspServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;


@WebListener
public class PlainListener implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();

		JspServlet servlet = new JspServlet();


		ServletRegistration.Dynamic registration = servletContext.addServlet("jspName", servlet);
		registration.addMapping("/jsp");
//		registration.setLoadOnStartup(1);
//		registration.addMapping("/jsp");


		System.out.println("servletContext start");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
