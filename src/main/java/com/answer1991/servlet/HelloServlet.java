package com.answer1991.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer1991.servlet.pojo.Student;
import com.answer1991.utils.logger.Hello;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	
	@Inject
	private Hello hello;
	
	private static final long serialVersionUID = -6253789689012470901L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.getWriter().write(hello.getMsg());
		
		Student s = new Student();
		s.setId("1234");
		s.setName(hello.getMsg());
		
		req.setAttribute("student", s);
		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);;
	}
}
