package com.answer1991.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import com.answer1991.ws.HelloServiceRemote;

/**
 * Servlet implementation class TestWSServlet
 */
@WebServlet("/TestWSServlet")
public class TestWSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//@WebServiceRef(wsdlLocation = "http://localhost:8082/account/HelloService?wsdl")
	//private static HelloServiceRemote service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestWSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().write(service.getPet("1").getOwner());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
