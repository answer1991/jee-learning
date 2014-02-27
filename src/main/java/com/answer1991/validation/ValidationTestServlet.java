package com.answer1991.validation;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ValidationTestServlet
 */
@WebServlet("/ValidationTestServlet")
public class ValidationTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(ValidationTestServlet.class);
    
	@Resource
	private Validator validator;
	
	private ValidatorFactory factory;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		User user = new User();
		user.setName("112");
		user.setIsActive(false);
		user.setEmail("fdafdfa");
		
		
		Set<ConstraintViolation<User>> result = validator.validate(user, Default.class);
		
		for(ConstraintViolation<User> con : result) {
			logger.error(con.getMessage());
			response.getWriter().append(con.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
