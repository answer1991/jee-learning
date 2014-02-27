package com.answer1991.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDestroyServlet
 */
@WebServlet("/TestDestroyServlet")
public class TestDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int serviceNum;
	private boolean isShuttingDown;
	
	protected synchronized int getServiceNum() {
		return serviceNum;
	}
	
	protected synchronized void enterService() {
		serviceNum++;
	}
	
	protected synchronized void leaveService () {
		serviceNum--;
	}
	
	protected synchronized void setShuttingDown(boolean isShuttingDown) {
		this.isShuttingDown = isShuttingDown;
	}
	
	protected synchronized boolean getShuttingDown() {
		return isShuttingDown;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		if(getServiceNum() > 0) {
			setShuttingDown(isShuttingDown);
		}
		
		while(getServiceNum() > 0) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException exception) {
				
			}
		}
	}
}
