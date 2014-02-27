package com.answer1991.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer1991.jsf.beans.ConveterTestBean;

/**
 * Servlet implementation class ConveterServlet
 */
@WebServlet("/ConveterServlet")
public class ConveterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ConveterTestBean testBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConveterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		testBean.setNumber(1);
		testBean.setDate(new Date());
		
		request.setAttribute("testBean", testBean);
		
		request.getRequestDispatcher("/WEB-INF/jsf/convert.xhtml");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
